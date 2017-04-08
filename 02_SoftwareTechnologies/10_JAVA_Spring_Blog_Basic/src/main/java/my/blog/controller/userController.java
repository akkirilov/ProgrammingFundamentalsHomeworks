package my.blog.controller;

import my.blog.repository.RoleRepository;
import my.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/register")
    public String register (Model model){
        model.addAttribute("view", "user/register");

        return "base-layout";
    }

}
