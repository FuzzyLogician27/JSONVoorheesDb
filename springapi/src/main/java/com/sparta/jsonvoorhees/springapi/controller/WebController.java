package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import com.sparta.jsonvoorhees.springapi.service.VoorheesWebService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    private final ServiceLayer serviceLayer;

    public WebController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/web/movies")
    public String getAllMovies(Model model, @RequestParam(name = "title", required = false) String title) {
        model.addAttribute("movies", serviceLayer.getAllMoviesWithTitle(title));
        return "movies";
    }

    @GetMapping("/web/movie/{id}")
    public String getMovieById(Model model, @PathVariable String id) {
        model.addAttribute("movie", serviceLayer.getMovieById(id).get());
        model.addAttribute("comments",serviceLayer.getCommentsByMovie(id));
        return "movie";
    }

    @GetMapping("/web/theaters")
    public String getAllTheaters(Model model) {
        model.addAttribute("theaters", serviceLayer.getAllTheaters());
        return "theaters";
    }

    @GetMapping("/web/theater/{id}")
    public String getTheaterById(Model model, @PathVariable String id) {
        model.addAttribute("theater",serviceLayer.getTheaterById(id).get());
        model.addAttribute("schedules",serviceLayer.getSchedulesForTheaters(id));
        return "theater";
    }

    @GetMapping("/web/user/{id}")
    public String getUserById(Model model, @PathVariable String id) {
        model.addAttribute("user",serviceLayer.getUserById(id).get());
        model.addAttribute("comments",serviceLayer.getCommentsByUser(id));
        return "user";
    }


}
