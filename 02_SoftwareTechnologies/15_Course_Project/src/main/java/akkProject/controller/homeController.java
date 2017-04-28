package akkProject.controller;

import akkProject.entity.*;
import akkProject.repository.AddRepository;
import akkProject.repository.NewsRepository;
import akkProject.repository.TrainingRepository;
import akkProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class homeController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddRepository addRepository;
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/")
    public String index(Model model){
        List<News> newsList = newsRepository.findAll();
        List<Training> trainingsList = trainingRepository.findAll();
        List<Add> addsList = addRepository.findAll();

        model.addAttribute("newsList", newsList);
        model.addAttribute("trainingsList", trainingsList);
        model.addAttribute("addsList", addsList);
        model.addAttribute("view", "home/index");
        return "base-layout";
    }
}
