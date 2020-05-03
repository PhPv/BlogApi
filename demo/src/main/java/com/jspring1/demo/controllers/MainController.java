package com.jspring1.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.mongodb.MongoDbFactory;


@Controller
public class MainController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Main page");
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About me");

        return "about";
    }
}