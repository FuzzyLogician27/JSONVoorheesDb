package com.sparta.jsonvoorhees.springapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeWebController {

    @GetMapping("/web/home")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getHomePage(Model model) {
        model.addAttribute("home");
        return "home";
    }
}
