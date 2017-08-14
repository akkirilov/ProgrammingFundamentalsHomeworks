package akkProject.controller;

import akkProject.entity.*;
import akkProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Controller
public class adminController {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private AddRepository addRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MainCategoryRepository mainCategoryRepository;
    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    @GetMapping("/admin")
    @PreAuthorize("isAuthenticated()")
    public String adminGet (Model model){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(principal.getUsername());

        if (!user.isAdmin()) {
            return "redirect:/";
        }

        model.addAttribute("view", "admin/admin");

        return "base-layout";
    }

    @GetMapping("/users")
    @PreAuthorize("isAuthenticated()")
    public String usersGet (Model model){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(principal.getUsername());

        if (!user.isAdmin()) {
            return "redirect:/";
        }

        List<User> users = this.userRepository.findAll();

        model.addAttribute("users", users);
        model.addAttribute("view", "admin/users");

        return "base-layout";
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("isAuthenticated()")
    public String usersGet (Model model, @PathVariable Integer id){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userAdmin = this.userRepository.findByEmail(principal.getUsername());

        if (!userAdmin.isAdmin()) {
            return "redirect:/";
        }

        User user = this.userRepository.findOne(id);

        model.addAttribute("userAdmin", userAdmin);
        model.addAttribute("user", user);
        model.addAttribute("view", "admin/user");

        return "base-layout";
    }

    @GetMapping("/user/{id}/adds")
    @PreAuthorize("isAuthenticated()")
    public String profileAddsGet(Model model, @PathVariable Integer id){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userAdmin = this.userRepository.findByEmail(principal.getUsername());

        if (!userAdmin.isAdmin()) {
            return "redirect:/";
        }
        if (!this.userRepository.exists(id)){
            return "redirect:/";
        }

        User user = this.userRepository.findOne(id);
        Set<Add> addsList = user.getAdds();

        model.addAttribute("addsList", addsList);
        model.addAttribute("view", "user/allAdds");
        return "base-layout";
    }

    @GetMapping("/user/{id}/news")
    @PreAuthorize("isAuthenticated()")
    public String profileNewsGet(Model model, @PathVariable Integer id){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userAdmin = this.userRepository.findByEmail(principal.getUsername());

        if (!userAdmin.isAdmin()) {
            return "redirect:/";
        }
        if (!this.userRepository.exists(id)){
            return "redirect:/";
        }

        User user = this.userRepository.findOne(id);
        Set<News> newsList = user.getNews();

        model.addAttribute("newsList", newsList);
        model.addAttribute("view", "user/allNews");
        return "base-layout";
    }

    @GetMapping("/user/{id}/trainings")
    @PreAuthorize("isAuthenticated()")
    public String profileTrainingsGet(Model model, @PathVariable Integer id){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userAdmin = this.userRepository.findByEmail(principal.getUsername());

        if (!userAdmin.isAdmin()) {
            return "redirect:/";
        }
        if (!this.userRepository.exists(id)){
            return "redirect:/";
        }

        User user = this.userRepository.findOne(id);
        Set<Training> trainingsList = user.getTrainings();

        model.addAttribute("trainingsList", trainingsList);
        model.addAttribute("view", "user/allTrainings");
        return "base-layout";
    }

    @GetMapping("/user/{id}/delete")
    @PreAuthorize("isAuthenticated()")
    public String userDeleteGet(Model model, @PathVariable Integer id){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userAdmin = this.userRepository.findByEmail(principal.getUsername());

        if (!userAdmin.isAdmin()) {
            return "redirect:/";
        }
        if (!this.userRepository.exists(id)){
            return "redirect:/";
        }
        User user = this.userRepository.findOne(id);

        Set<Add> addsSet = user.getAdds();
        for (Add add : addsSet) {
            AddCategory addCategory = add.getAddCategory();
            addCategory.removeAdd(add);
            this.addRepository.delete(add);
        }

        Set<Training> trainingSet = user.getTrainings();
        for (Training training : trainingSet) {
            TrainingCategory trainingCategory = training.getTrainingCategory();
            trainingCategory.removeTraining(training);
            this.trainingRepository.delete(training);
        }

        Set<News> newsSet = user.getNews();
        for (News news : newsSet) {
            this.newsRepository.delete(news);
        }

        Set<MainCategory> mainCategoriesSet = user.getMainCategories();
        for (MainCategory category : mainCategoriesSet) {
            user.removeMainCategory(category);
        }

        Set<Role> roleSet = user.getRoles();
        for (Role role : roleSet) {
            user.removeRole(role);
        }

        ContactDetails contactDetails = user.getContactDetails();
        contactDetails.removeDetailsUserId(user);

        this.userRepository.delete(user);

        return "redirect:/users";
    }
}
