package com.sparta.jsonvoorhees.springapi.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeWebController {

    @GetMapping("/web/home")
    public String getHomePage(Model model) {
        model.addAttribute("home");
        return "home";
    }
}
