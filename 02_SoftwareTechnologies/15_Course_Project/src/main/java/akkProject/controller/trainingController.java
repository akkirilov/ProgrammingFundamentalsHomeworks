package akkProject.controller;


import akkProject.bindingModel.TrainingBindingModel;
import akkProject.entity.Training;
import akkProject.entity.TrainingCategory;
import akkProject.entity.User;
import akkProject.repository.TrainingCategoryRepository;
import akkProject.repository.TrainingRepository;
import akkProject.repository.UserRepository;
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

import java.util.List;
import java.util.Set;

@Controller
public class trainingController {
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private TrainingCategoryRepository trainingCategoryRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/trainings")
    public String index(Model model){
        List<Training> trainingsList = trainingRepository.findAll();

        model.addAttribute("trainingsList", trainingsList);
        model.addAttribute("view", "training/trainings");
        return "base-layout";
    }

    @GetMapping("/training/{id}")
    @PreAuthorize("isAuthenticated()")
    public String detailsGet(Model model, @PathVariable Integer id){
        Training training = trainingRepository.findOne(id);
        if(!(SecurityContextHolder.getContext().getAuthentication()instanceof AnonymousAuthenticationToken)){
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = this.userRepository.findByEmail(principal.getUsername());
            model.addAttribute("user", user);
        }

        model.addAttribute("training", training);
        model.addAttribute("view", "training/details");
        return "base-layout";
    }

    @GetMapping("/training/create")
    @PreAuthorize("isAuthenticated()")
    public String createGet(Model model){

        List<TrainingCategory> trainingCategorySet = trainingCategoryRepository.findAll();
        model.addAttribute("trainingCategorySet", trainingCategorySet);
        model.addAttribute("view", "training/create");
        return "base-layout";
    }

    @PostMapping("/training/create")
    @PreAuthorize("isAuthenticated()")
    public String createPost (TrainingBindingModel trainingBindingModel){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(principal.getUsername());

        Training training = new Training(
                trainingBindingModel.getTitle(),
                trainingBindingModel.getContent(),
                user
        );
        training.setLocation(trainingBindingModel.getLocation());

        TrainingCategory trainingCategory = trainingCategoryRepository.findOne(Integer.parseInt(trainingBindingModel.getTrainingCategory()));
        training.setTrainingCategory(trainingCategory);

        user.addTraining(training);
        trainingCategory.addTrainings(training);
        this.trainingRepository.saveAndFlush(training);

        return "redirect:/";
    }

    @GetMapping("/training/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editGet (Model model, @PathVariable Integer id){
        if (!this.trainingRepository.exists(id)){
            return "redirect:/";
        }

        Training training = this.trainingRepository.findOne(id);
        if(!isUserTrainerOrAdmin(training)){
            return "redirect:/training/" + id;
        }

        List<TrainingCategory> trainingCategorySet = trainingCategoryRepository.findAll();
        model.addAttribute("trainingCategorySet", trainingCategorySet);
        model.addAttribute("training", training);
        model.addAttribute("view", "training/edit");

        return "base-layout";
    }

    @PostMapping("/training/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editPost (TrainingBindingModel trainingBindingModel, @PathVariable Integer id){
        if (!this.trainingRepository.exists(id)){
            return "redirect:/";
        }

        Training training = this.trainingRepository.findOne(id);
        if(!isUserTrainerOrAdmin(training)){
            return "redirect:/training/" + id;
        }
        training.setTitle(trainingBindingModel.getTitle());
        training.setContent(trainingBindingModel.getContent());
        training.setLocation(trainingBindingModel.getLocation());

        TrainingCategory trainingCategory = trainingCategoryRepository.findOne(Integer.parseInt(trainingBindingModel.getTrainingCategory()));
        training.setTrainingCategory(trainingCategory);

        this.trainingRepository.saveAndFlush(training);

        return "redirect:/training/" + id;
    }

    @GetMapping("/training/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deleteGet (Model model, @PathVariable Integer id){
        if (!this.trainingRepository.exists(id)){
            return "redirect:/";
        }

        Training training = this.trainingRepository.findOne(id);
        if(!isUserTrainerOrAdmin(training)){
            return "redirect:/training/" + id;
        }
        model.addAttribute("training", training);
        model.addAttribute("view", "training/delete");

        return "base-layout";
    }

    @PostMapping("/training/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deletePost (@PathVariable Integer id){
        if (!this.trainingRepository.exists(id)){
            return "redirect:/";
        }

        Training training = this.trainingRepository.findOne(id);
        if(!isUserTrainerOrAdmin(training)){
            return "redirect:/training/" + id;
        }

        User user = training.getTrainingUserId();
        user.removeTraining(training);

        TrainingCategory trainingCategory = training.getTrainingCategory();
        trainingCategory.removeTraining(training);

        user.removeTraining(training);

        this.trainingRepository.delete(training);

        return "redirect:/";
    }

    public Boolean isUserTrainerOrAdmin(Training training){
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(userDetails.getUsername());

        return user.isAdmin() || user.isTrainingAuthor(training);
    }
}
