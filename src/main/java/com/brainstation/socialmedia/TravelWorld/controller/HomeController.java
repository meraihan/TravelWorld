package com.brainstation.socialmedia.TravelWorld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String landingPage() {
        return "landing_page";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard/dashboard";
    }

    @GetMapping("/404")
    public String error() {
        return "error/error";
    }
}