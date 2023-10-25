package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.entities.Theater;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TheaterWebController {
    private final ServiceLayer serviceLayer;

    public TheaterWebController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/web/theaters")
    public String getAllTheaters(Model model) {
        model.addAttribute("theaters", serviceLayer.getAllTheaters());
        return "/theater/theaters";
    }

    @GetMapping("/web/theater/{id}")
    public String getTheaterById(Model model, @PathVariable String id) {
        model.addAttribute("theater",serviceLayer.getTheaterById(id).get());
        model.addAttribute("schedules",serviceLayer.getSchedulesForTheaters(id));
        return "/theater/theater";
    }

    @GetMapping("/web/theater/create")
    public String getCreateForm(Model model) {
        model.addAttribute("theaterToCreate",new Theater());
        return "/theater/theater-create-form";
    }

    @PostMapping("/web/createTheater")
    public String createTheater(@ModelAttribute("theaterToCreate") Theater theater) {
        serviceLayer.addTheater(theater);
        return "create-success";
    }

    @GetMapping("/web/theater/edit/{id}")
    public String getEditForm(Model model, @PathVariable String id) {
        model.addAttribute("theaterToEdit", serviceLayer.getTheaterById(id).orElse(null));
        return "/theater/theater-edit-form";
    }

    @PostMapping("/web/updateTheater")
    public String updateTheater(@ModelAttribute("theaterToEdit") Theater theater) {
        //Theater existingTheater = serviceLayer.getTheaterById(theater.getId()).get();
        serviceLayer.updateTheater(theater);
        return "edit-success";
    }

    @GetMapping("/web/theater/delete/{id}")
    public String getDeleteForm(Model model, @PathVariable String id) {
        model.addAttribute("theaterToDelete", serviceLayer.getTheaterById(id).orElse(null));
        return "/theater/theater-delete-form";
    }

    @PostMapping("/web/deleteTheater")
    public String deleteTheater(@ModelAttribute("theaterToDelete") Theater theater) {
        serviceLayer.deleteTheaterById(theater.getId());
        return "delete-success";
    }
}
