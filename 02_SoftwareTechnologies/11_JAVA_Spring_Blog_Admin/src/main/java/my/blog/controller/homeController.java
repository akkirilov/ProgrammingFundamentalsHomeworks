package my.blog.controller;

import my.blog.repository.ArticleRepository;
import my.blog.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class homeController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Article> articleList = articleRepository.findAll();
        int skip = 6;
        if (articleList.size() < 6) {
            skip = articleList.size();
        }
        articleList = articleList.stream().skip(articleList.size() - skip).collect(Collectors.toList());
        Collections.reverse(articleList);

        model.addAttribute("articles", articleList);
        model.addAttribute("view", "home/index");

        return "base-layout";
    }
}
