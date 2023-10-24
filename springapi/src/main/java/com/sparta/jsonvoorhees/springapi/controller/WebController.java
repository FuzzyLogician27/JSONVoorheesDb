package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.service.VoorheesWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    private final VoorheesWebService voorheesWebService;

    public WebController(VoorheesWebService voorheesWebService) {
        this.voorheesWebService = voorheesWebService;
    }

    @GetMapping("/web/movies")
    public String getAllMovies(Model model, @RequestParam(name = "title", required = false) String title) {
        model.addAttribute("movies", voorheesWebService.getAllMoviesWithTitle(title));
        return "movies";
    }
    @GetMapping("/web/theaters")
    public String getAllTheatres(Model model){
        model.addAttribute("theaters",voorheesWebService.getAllTheaters());
                return "theaters";
    }
    @GetMapping("/web/comments")
    public String getAllComments(Model model, @RequestParam(name = "name", required = false) String title){
        if(title == null)
        model.addAttribute("comments",voorheesWebService.getAllComments());
        else
            model.addAttribute("comments",voorheesWebService.getCommentsByNameContains(title));
        return "comments";
    }
        @GetMapping("/web/comments/{id}")
        public String getCommentsByMovieId(Model model, @PathVariable String id) {
            //model.addAttribute("comments", serviceLayer.getCommentsByMovie(id));
            model.addAttribute("comments", voorheesWebService.getCommentsByMovieId(id));
            return "comments";
        }
}