package akkProject.controller;

import akkProject.bindingModel.UserBindingModel;
import akkProject.entity.ContactDetails;
import akkProject.entity.MainCategory;
import akkProject.entity.Role;
import akkProject.entity.User;
import akkProject.repository.ContactDetailsRepository;
import akkProject.repository.MainCategoryRepository;
import akkProject.repository.RoleRepository;
import akkProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class userController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MainCategoryRepository mainCategoryRepository;
    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    @GetMapping("/register")
    public String registerGet(Model model) {
        List<MainCategory> mainCategories = mainCategoryRepository.findAll();

        model.addAttribute("mainCategories", mainCategories);
        model.addAttribute("view", "user/register");

        return "base-layout";
    }

    @PostMapping("/register")
    public String registerPost(UserBindingModel userBindingModel, @RequestParam("mainCategories[]") String[] mainCategories) {
        if (!userBindingModel.getPassword().equals(userBindingModel.getConfirmPassword())) {
            return "redirect:/register";
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user = new User(
                userBindingModel.getName(),
                userBindingModel.getEmail(),
                bCryptPasswordEncoder.encode(userBindingModel.getPassword())
        );

        Role role = this.roleRepository.findByRoleName("ROLE_USER");
        user.addRole(role);
        String dataBaseImagePath = null;

        if (isImageAllowed(userBindingModel.getLogo())) {
            String fileName = userBindingModel.getEmail() + ".jpg";

            String logoSavePath = System.getProperty("user.dir")
                    + "\\src\\main\\resources\\static\\images\\logo\\" + fileName;

            File imageFile = new File(logoSavePath);
            try {
                userBindingModel.getLogo().transferTo(imageFile);
                dataBaseImagePath = "/images/logo/" + fileName;
                user.setLogoUrl(dataBaseImagePath);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (String categoryId : mainCategories) {
            user.addMainCategory(mainCategoryRepository.findOne(Integer.parseInt(categoryId)));
            System.out.println(categoryId);
        }
        user.setType(userBindingModel.getType());

        this.userRepository.saveAndFlush(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginGet(Model model) {
        model.addAttribute("view", "user/login");
        return "base-layout";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:login?logout";
    }

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String profileGet(Model model) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = this.userRepository.findByEmail(principal.getUsername());

        ContactDetails contactDetails = user.getContactDetails();
        if (contactDetails == null) {
            contactDetails = new ContactDetails();
        }

        model.addAttribute("contactDetails", contactDetails);
        model.addAttribute("user", user);
        model.addAttribute("view", "user/profile");

        return "base-layout";
    }

    private boolean isImageAllowed(MultipartFile logo) {
        String[] allowedTypes = {
                "image/png",
                "image/jpeg",
                "image/jpg"
        };

        return Arrays.asList(allowedTypes).contains(logo.getContentType());
    }
}