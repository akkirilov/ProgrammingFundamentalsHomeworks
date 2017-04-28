package akkProject.controller;

import akkProject.bindingModel.ContactBindingModel;
import akkProject.bindingModel.UserBindingModel;
import akkProject.entity.*;
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
import java.util.*;

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
        user.setSummary(userBindingModel.getSummary());

        this.userRepository.saveAndFlush(user);

        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setDetailsUserId(user);
        this.contactDetailsRepository.saveAndFlush(contactDetails);
        user.setContactDetails(contactDetails);

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

    @GetMapping("/myProfile")
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

    @GetMapping("/profile/details/{id}")
    @PreAuthorize("isAuthenticated()")
    public String detailsGet(Model model, @PathVariable Integer id) {
        if (!this.userRepository.exists(id)){
            return "redirect:/";
        }
        User user = this.userRepository.findOne(id);

        ContactDetails contactDetails = user.getContactDetails();
        if (contactDetails == null) {
            contactDetails = new ContactDetails();
        }

        model.addAttribute("user", user);
        model.addAttribute("contactDetails", contactDetails);
        model.addAttribute("view", "user/details");

        return "base-layout";
    }

    @PostMapping("/profile/details/{id}")
    @PreAuthorize("isAuthenticated()")
    public String detailsPost(ContactBindingModel contactBindingModel, @PathVariable Integer id) {
        if (!this.userRepository.exists(id)){
            return "redirect:/";
        }
        User user = this.userRepository.findOne(id);

        ContactDetails contactDetails = user.getContactDetails();
        if (contactDetails == null) {
            contactDetails = new ContactDetails();
            contactDetails.setDetailsUserId(user);
            this.contactDetailsRepository.saveAndFlush(contactDetails);
        }

        contactDetails.setPhone(contactBindingModel.getPhone());
        contactDetails.setFax(contactBindingModel.getFax());
        contactDetails.setWeb(contactBindingModel.getWeb());
        contactDetails.setCountry(contactBindingModel.getCountry());
        contactDetails.setCity(contactBindingModel.getCity());
        contactDetails.setAddress(contactBindingModel.getAddress());

        user.setContactDetails(contactDetails);
        this.userRepository.saveAndFlush(user);

        return "redirect:/myProfile";
    }

    @GetMapping("/profile/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editGet(Model model, @PathVariable Integer id) {
        if (!this.userRepository.exists(id)){
            return "redirect:/";
        }
        User user = this.userRepository.findOne(id);
        List<MainCategory> mainCategories = mainCategoryRepository.findAll();

        model.addAttribute("mainCategories", mainCategories);
        model.addAttribute("user", user);
        model.addAttribute("view", "user/edit");

        return "base-layout";
    }

    @PostMapping("/profile/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editPost(UserBindingModel userBindingModel, @RequestParam("mainCategories[]") String[] mainCategories, @PathVariable Integer id) {
        if (!this.userRepository.exists(id)){
            return "redirect:/";
        }
        User user = this.userRepository.findOne(id);

        user.setSummary(userBindingModel.getSummary());
        user.setType(userBindingModel.getType());

        if (userBindingModel.getPassword() != null && !userBindingModel.getConfirmPassword().equals("")) {
            if (!userBindingModel.getPassword().equals(userBindingModel.getConfirmPassword())) {
                return "redirect:/profile/edit/" + id;
            }
            else {
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                user.setPassword(bCryptPasswordEncoder.encode(userBindingModel.getPassword()));
            }
        }

        if (userBindingModel.getLogo() != null && isImageAllowed(userBindingModel.getLogo())) {
            String fileName = userBindingModel.getEmail() + ".jpg";

            String logoSavePath = System.getProperty("user.dir")
                    + "\\src\\main\\resources\\static\\images\\logo\\" + fileName;

            File imageFile = new File(logoSavePath);
            try {
                userBindingModel.getLogo().transferTo(imageFile);
                user.setLogoUrl(logoSavePath);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        Set<MainCategory> replaceCategories = new HashSet<>();
        for (String categoryId : mainCategories) {
            replaceCategories.add(mainCategoryRepository.findOne(Integer.parseInt(categoryId)));
        }
        if (replaceCategories != null) {
            user.setMainCategories(replaceCategories);
        }

        this.userRepository.saveAndFlush(user);

        return "redirect:/myProfile";
    }

    @GetMapping("/myProfile/{id}/news")
    @PreAuthorize("isAuthenticated()")
    public String profileNewsGet(Model model, @PathVariable Integer id){
        if (!this.userRepository.exists(id)){
            return "redirect:/";
        }
        User user = this.userRepository.findOne(id);
        Set<News> newsList = user.getNews();

        model.addAttribute("newsList", newsList);
        model.addAttribute("view", "user/allNews");
        return "base-layout";
    }

    @GetMapping("/myProfile/{id}/trainings")
    @PreAuthorize("isAuthenticated()")
    public String profileTrainingsGet(Model model, @PathVariable Integer id){
        if (!this.userRepository.exists(id)){
            return "redirect:/";
        }
        User user = this.userRepository.findOne(id);
        Set<Training> trainingsList = user.getTrainings();

        model.addAttribute("trainingsList", trainingsList);
        model.addAttribute("view", "user/allTrainings");
        return "base-layout";
    }

    @GetMapping("/myProfile/{id}/adds")
    @PreAuthorize("isAuthenticated()")
    public String profileAddsGet(Model model, @PathVariable Integer id){
        if (!this.userRepository.exists(id)){
            return "redirect:/";
        }
        User user = this.userRepository.findOne(id);
        Set<Add> addsList = user.getAdds();

        model.addAttribute("addsList", addsList);
        model.addAttribute("view", "user/allAdds");
        return "base-layout";
    }

    @GetMapping("/companies")
    public String companiesGet(Model model){
        User user = new User();
        try {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            user = this.userRepository.findByEmail(principal.getUsername());
        }
        catch (Exception ex){   }

        if (user.getEmail() != null) {
            model.addAttribute("mainUser", user);
        }

        List<User> users = this.userRepository.findAll();

        model.addAttribute("users", users);
        model.addAttribute("view", "user/all");
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