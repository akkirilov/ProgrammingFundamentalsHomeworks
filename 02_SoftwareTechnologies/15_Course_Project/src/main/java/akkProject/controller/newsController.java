package akkProject.controller;

import akkProject.bindingModel.NewsBindingModel;
import akkProject.entity.News;
import akkProject.entity.User;
import akkProject.repository.NewsRepository;
import akkProject.repository.UserRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Controller
public class newsController {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/news")
    public String index(Model model){
        List<News> newsList = newsRepository.findAll();

        model.addAttribute("newsList", newsList);
        model.addAttribute("view", "news/news");
        return "base-layout";
    }

    @GetMapping("/news/{id}")
    @PreAuthorize("isAuthenticated()")
    public String detailsGet(Model model, @PathVariable Integer id){
        News news = newsRepository.findOne(id);
        if(!(SecurityContextHolder.getContext().getAuthentication()instanceof AnonymousAuthenticationToken)){
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = this.userRepository.findByEmail(principal.getUsername());
            model.addAttribute("user", user);
        }

        model.addAttribute("news", news);
        model.addAttribute("view", "news/details");
        return "base-layout";
    }

    @GetMapping("/news/create")
    @PreAuthorize("isAuthenticated()")
    public String createGet(Model model){

        model.addAttribute("view", "news/create");
        return "base-layout";
    }

    @PostMapping("/news/create")
    @PreAuthorize("isAuthenticated()")
    public String createPost (NewsBindingModel newsBindingModel){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(principal.getUsername());

        News news = new News(
                newsBindingModel.getTitle(),
                newsBindingModel.getContent(),
                user
        );

        user.addNews(news);
        this.newsRepository.saveAndFlush(news);

        return "redirect:/";
    }

    @GetMapping("/news/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editGet (Model model, @PathVariable Integer id){
        if (!this.newsRepository.exists(id)){
            return "redirect:/";
        }

        News news = this.newsRepository.findOne(id);
        if(!isUserAuthorOrAdmin(news)){
            return "redirect:/news/" + id;
        }

        model.addAttribute("news", news);
        model.addAttribute("view", "news/edit");

        return "base-layout";
    }

    @PostMapping("/news/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editPost (NewsBindingModel newsBindingModel, @PathVariable Integer id){
        if (!this.newsRepository.exists(id)){
            return "redirect:/";
        }

        News news = this.newsRepository.findOne(id);
        if(!isUserAuthorOrAdmin(news)){
            return "redirect:/news/" + id;
        }
        news.setTitle(newsBindingModel.getTitle());
        news.setContent(newsBindingModel.getContent());

        this.newsRepository.saveAndFlush(news);

        return "redirect:/news/" + id;
    }

    @GetMapping("/news/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deleteGet (Model model, @PathVariable Integer id){
        if (!this.newsRepository.exists(id)){
            return "redirect:/";
        }

        News news = this.newsRepository.findOne(id);
        if(!isUserAuthorOrAdmin(news)){
            return "redirect:/news/" + id;
        }
        model.addAttribute("news", news);
        model.addAttribute("view", "news/delete");

        return "base-layout";
    }

    @PostMapping("/news/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deletePost (@PathVariable Integer id){
        if (!this.newsRepository.exists(id)){
            return "redirect:/";
        }

        News news = this.newsRepository.findOne(id);
        if(!isUserAuthorOrAdmin(news)){
            return "redirect:/news/" + id;
        }

        User user = news.getNewsUserId();
        user.removeNews(news);

        this.newsRepository.delete(news);

        return "redirect:/";
    }

    public Boolean isUserAuthorOrAdmin(News article){
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(userDetails.getUsername());

        return user.isAdmin() || user.isNewsAuthor(article);
    }
}
