package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.repositories.CommentRepository;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    private final ServiceLayer serviceLayer;

    private final CommentRepository commentRepository;

    public WebController(ServiceLayer serviceLayer, CommentRepository commentRepository) {
        this.serviceLayer = serviceLayer;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/web/comment/{id}")
    public String getCommentsById(Model model, @PathVariable String id) {
        model.addAttribute("comments", serviceLayer.getCommentById(id).get());
        return "comment";
    }

}
