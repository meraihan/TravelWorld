package com.brainstation.socialmedia.TravelWorld.controller;

import com.brainstation.socialmedia.TravelWorld.model.User;
import com.brainstation.socialmedia.TravelWorld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/find")
    public String findUserPageDisplay() {
        return "user/search";
    }


    @PostMapping("/find")
    public String findUserByusername(@ModelAttribute("userName") String username, Model model) {
        User user = userService.getUser(username);
        if (user != null) {
            List<User> users = new ArrayList<>();
            users.add(user);
            model.addAttribute("users", users);
        }
        return "user/all";
    }


    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        List<String> genders = new ArrayList<>();
        genders.add("MALE");
        genders.add("FEMALE");
        genders.add("OTHER");
        model.addAttribute("genders", genders);
        model.addAttribute("user", new User());
        return "user/add";
    }


    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") User user, Model model, final RedirectAttributes redirectAttributes) {
        if (user.getRole() == null) {
            user.setRole(User.Role.USER);
        }
        user = userService.addUser(user);
        if (user != null) {
            redirectAttributes.addFlashAttribute("success", "Please log in");
            return "redirect:/";
        } else {
            return "redirect:/user/register";
        }
    }

    @GetMapping("/list")
    public String findAllUsers(Model model) {
        List<User> list;
        list = userService.getAllUsers();
        model.addAttribute("users", list);
        return "user/all";
    }
}