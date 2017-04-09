package my.blog.controller;

import my.blog.bindingModel.ArticleBindingModel;
import my.blog.entity.Article;
import my.blog.entity.User;
import my.blog.repository.ArticleRepository;
import my.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class articleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/article/create")
    @PreAuthorize("isAuthenticated()")
    public String createGet (Model model){
        model.addAttribute("view", "article/create");

        return "base-layout";

    }

    @PostMapping("/article/create")
    @PreAuthorize("isAuthenticated()")
    public String createPost (ArticleBindingModel articleBindingModel){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(principal.getUsername());

        Article article = new Article(
                articleBindingModel.getTitle(),
                articleBindingModel.getContent(),
                user
        );

        this.articleRepository.saveAndFlush(article);

        return "redirect:/";
    }

    @GetMapping("/article/{id}")
    public String detailsGet (Model model, @PathVariable Integer id){
        if(!this.articleRepository.exists(id)){
            return "redirect:/";
        }

        Article article = this.articleRepository.findOne(id);

        model.addAttribute("article", article);
        model.addAttribute("view", "article/details");

        return "base-layout";
    }

}
