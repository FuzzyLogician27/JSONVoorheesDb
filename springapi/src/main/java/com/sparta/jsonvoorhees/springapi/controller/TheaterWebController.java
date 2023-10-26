package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.entities.Theater;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.Address;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.Geo;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.Location;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TheaterWebController {
    private final ServiceLayer serviceLayer;

    public TheaterWebController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/web/theaters")
    @ResponseStatus(HttpStatus.OK)
    public String getAllTheaters(Model model) {
        model.addAttribute("theaters", serviceLayer.getAllTheaters());
        return "theater/theaters";
    }

    @GetMapping("/web/theater/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getTheaterById(Model model, @PathVariable String id) {
        model.addAttribute("theater",serviceLayer.getTheaterById(id).get());
        model.addAttribute("schedules",serviceLayer.getSchedulesForTheaters(id));
        return "theater/theater";
    }

    @GetMapping("/web/theater/create")
    @ResponseStatus(HttpStatus.OK)
    public String getCreateForm(Model model) {
        Location location = new Location(new Address(null,null,null,null),new Geo(null,null));
        Theater theater = new Theater();
        theater.setLocation(location);
        model.addAttribute("theaterToCreate",theater);
        return "theater/theater-create-form";
    }

    @PostMapping("/web/createTheater")
    @ResponseStatus(HttpStatus.OK)
    public String createTheater(@ModelAttribute("theaterToCreate") Theater theater) {
        serviceLayer.addTheater(theater);
        return "create-success";
    }

    @GetMapping("/web/theater/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getEditForm(Model model, @PathVariable String id) {
        model.addAttribute("theaterToEdit", serviceLayer.getTheaterById(id).orElse(null));
        return "theater/theater-edit-form";
    }

    @PostMapping("/web/updateTheater")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateTheater(@ModelAttribute("theaterToEdit") Theater theater) {
        Theater existingTheater = serviceLayer.getTheaterById(theater.getId()).get();
        existingTheater.setId(theater.getId());
        Location location = existingTheater.getLocation();
        location.setAddress(theater.getLocation().getAddress());
        existingTheater.setLocation(location);
        serviceLayer.updateTheater(existingTheater);
        return "edit-success";
    }

    @GetMapping("/web/theater/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getDeleteForm(Model model, @PathVariable String id) {
        model.addAttribute("theaterToDelete", serviceLayer.getTheaterById(id).orElse(null));
        return "theater/theater-delete-form";
    }

    @PostMapping("/web/deleteTheater")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTheater(@ModelAttribute("theaterToDelete") Theater theater) {
        serviceLayer.deleteTheaterById(theater.getId());
        return "delete-success";
    }
}
