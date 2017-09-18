package akkProject.controller;


import akkProject.bindingModel.AddBindingModel;
import akkProject.entity.Add;
import akkProject.entity.AddCategory;
import akkProject.entity.TrainingCategory;
import akkProject.entity.User;
import akkProject.repository.AddCategoryRepository;
import akkProject.repository.AddRepository;
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
public class addController {
    @Autowired
    private AddRepository addRepository;
    @Autowired
    private AddCategoryRepository addCategoryRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/adds")
    public String index(Model model){
        List<Add> addsList = addRepository.findAll();

        model.addAttribute("addsList", addsList);
        model.addAttribute("view", "add/adds");
        return "base-layout";
    }

    @GetMapping("/add/{id}")
    @PreAuthorize("isAuthenticated()")
    public String detailsGet(Model model, @PathVariable Integer id){
        Add add = addRepository.findOne(id);
        if(!(SecurityContextHolder.getContext().getAuthentication()instanceof AnonymousAuthenticationToken)){
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = this.userRepository.findByEmail(principal.getUsername());
            model.addAttribute("user", user);
        }

        model.addAttribute("add", add);
        model.addAttribute("view", "add/details");
        return "base-layout";
    }

    @GetMapping("/add/create")
    @PreAuthorize("isAuthenticated()")
    public String createGet(Model model){

        List<AddCategory> addCategorySet = addCategoryRepository.findAll();
        model.addAttribute("addCategorySet", addCategorySet);
        model.addAttribute("view", "add/create");
        return "base-layout";
    }

    @PostMapping("/add/create")
    @PreAuthorize("isAuthenticated()")
    public String createPost (AddBindingModel addBindingModel){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(principal.getUsername());

        Add add = new Add(
                addBindingModel.getTitle(),
                addBindingModel.getContent(),
                user
        );

        AddCategory addCategory = addCategoryRepository.findOne(Integer.parseInt(addBindingModel.getaddCategory()));
        add.setAddCategory(addCategory);

        user.addAdd(add);
        addCategory.addAdd(add);
        this.addRepository.saveAndFlush(add);

        return "redirect:/";
    }

    @GetMapping("/add/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editGet (Model model, @PathVariable Integer id){
        if (!this.addRepository.exists(id)){
            return "redirect:/";
        }

        Add add = this.addRepository.findOne(id);
        if(!isUserAddOrAdmin(add)){
            return "redirect:/add/" + id;
        }

        List<AddCategory> addCategorySet = addCategoryRepository.findAll();
        model.addAttribute("addCategorySet", addCategorySet);
        model.addAttribute("add", add);
        model.addAttribute("view", "add/edit");

        return "base-layout";
    }

    @PostMapping("/add/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editPost (AddBindingModel addBindingModel, @PathVariable Integer id){
        if (!this.addRepository.exists(id)){
            return "redirect:/";
        }

        Add add = this.addRepository.findOne(id);
        if(!isUserAddOrAdmin(add)){
            return "redirect:/add/" + id;
        }
        add.setTitle(addBindingModel.getTitle());
        add.setContent(addBindingModel.getContent());

        AddCategory addCategory = addCategoryRepository.findOne(Integer.parseInt(addBindingModel.getaddCategory()));
        add.setAddCategory(addCategory);

        this.addRepository.saveAndFlush(add);

        return "redirect:/add/" + id;
    }

    @GetMapping("/add/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deleteGet (Model model, @PathVariable Integer id){
        if (!this.addRepository.exists(id)){
            return "redirect:/";
        }

        Add add = this.addRepository.findOne(id);
        if(!isUserAddOrAdmin(add)){
            return "redirect:/add/" + id;
        }
        model.addAttribute("add", add);
        model.addAttribute("view", "add/delete");

        return "base-layout";
    }

    @PostMapping("/add/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deletePost (@PathVariable Integer id){
        if (!this.addRepository.exists(id)){
            return "redirect:/";
        }

        Add add = this.addRepository.findOne(id);
        if(!isUserAddOrAdmin(add)){
            return "redirect:/add/" + id;
        }

        User user = add.getAddUserId();
        user.removeAdd(add);

        AddCategory addCategory = add.getAddCategory();
        addCategory.removeAdd(add);

        this.addRepository.delete(add);

        return "redirect:/";
    }

    public Boolean isUserAddOrAdmin(Add add){
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = this.userRepository.findByEmail(userDetails.getUsername());

        return user.isAdmin() || user.isAddAuthor(add);
    }
}
