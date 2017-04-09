package my.blog.controller;

import my.blog.repository.ArticleRepository;
import my.blog.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class homeController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Article> articleList = articleRepository.findAll();

        model.addAttribute("articles", articleList);
        model.addAttribute("view", "home/index");

        return "base-layout";
    }
}
