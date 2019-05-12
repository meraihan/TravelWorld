package com.brainstation.socialmedia.TravelWorld.controller;

import com.brainstation.socialmedia.TravelWorld.model.Posts;
import com.brainstation.socialmedia.TravelWorld.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostsController {

    @Autowired
    PostService postService;

    @GetMapping("/list")
    public String findAllUsers(Model model) {
        List<Posts> list;
        list = postService.findAllPost();
        model.addAttribute("posts", list);
        return "post/add";
    }

    @PostMapping("/addPost")
    public String addPost(@ModelAttribute("posts") Posts posts, Model model, final RedirectAttributes redirectAttributes) {
        posts = postService.addPost(posts);
        if (posts != null) {
            redirectAttributes.addFlashAttribute("success", "Post Successful");
            return "redirect:/";
        } else {
            return "redirect:/post/addPost";
        }
    }

    @PostMapping("/find/{userId}")
    public String findPostByUserId(@PathVariable int userId, Model model) {
        Posts post = postService.getPost(userId);
        if (post != null) {
            List<Posts> posts = new ArrayList<>();
            posts.add(post);
            model.addAttribute("posts", posts);
        }
        return "post/post";
    }

}