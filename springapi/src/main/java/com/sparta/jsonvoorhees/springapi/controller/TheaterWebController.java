package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.entities.Schedule;
import com.sparta.jsonvoorhees.springapi.model.entities.Theater;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.Address;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.Geo;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.Location;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.ScheduleVM;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TheaterWebController {
    private final ServiceLayer serviceLayer;

    public TheaterWebController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/web/theaters")
    public String getAllTheaters(Model model,
                               @RequestParam(name="page", required = false) Optional<Integer> page,
                               @RequestParam(name="pageSize", required = false) Optional<Integer> pageSize) {

        model.addAttribute("theaters", serviceLayer.getAllTheaters(
                PageRequest.of(
                        page.orElse(1)-1,
                        pageSize.orElse(50))));
        return "/theater/theaters";
    }

    @GetMapping("/web/theater/{id}")
    public String getTheaterById(Model model, @PathVariable String id) {
        model.addAttribute("theater",serviceLayer.getTheaterById(id).get());

        List<Schedule> schedules = serviceLayer.getSchedulesForTheaters(id);
        List<ScheduleVM> scheduleVMs = new ArrayList<>();
        for (Schedule schedule : schedules) {
            ScheduleVM scheduleVM = new ScheduleVM();
            scheduleVM.setSchedule(schedule);
            if (serviceLayer.getMovieById(schedule.getMovieId()).isPresent()) {
                scheduleVM.setMovie(serviceLayer.getMovieById(schedule.getMovieId()).get());
            }
            scheduleVMs.add(scheduleVM);
        }
        model.addAttribute("scheduleVMs", scheduleVMs);

        Schedule schedule = new Schedule();
        schedule.setTheaterId(id);
        model.addAttribute("scheduleToCreate",schedule);
        return "theater/theater";
    }

    @PostMapping("/web/theater/createSchedule/{theaterId}")
    public String createSchedule(Model model, @PathVariable String theaterId, @ModelAttribute("scheduleToCreate") Schedule schedule) {
        model.addAttribute("theater", serviceLayer.getTheaterById(theaterId));
        serviceLayer.addSchedule(schedule);
        return "theater/schedule-added";
    }

    @GetMapping("/web/theater/create")
    public String getCreateForm(Model model) {
        Location location = new Location(new Address(null,null,null,null),new Geo(null,null));
        Theater theater = new Theater();
        theater.setLocation(location);
        model.addAttribute("theaterToCreate",theater);
        return "theater/theater-create-form";
    }

    @PostMapping("/web/createTheater")
    public String createTheater(@ModelAttribute("theaterToCreate") Theater theater) {
        serviceLayer.addTheater(theater);
        return "create-success";
    }

    @GetMapping("/web/theater/edit/{id}")
    public String getEditForm(Model model, @PathVariable String id) {
        model.addAttribute("theaterToEdit", serviceLayer.getTheaterById(id).orElse(null));
        return "theater/theater-edit-form";
    }

    @PostMapping("/web/updateTheater")
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
    public String getDeleteForm(Model model, @PathVariable String id) {
        model.addAttribute("theaterToDelete", serviceLayer.getTheaterById(id).orElse(null));
        return "theater/theater-delete-form";
    }

    @PostMapping("/web/deleteTheater")
    public String deleteTheater(@ModelAttribute("theaterToDelete") Theater theater) {
        serviceLayer.deleteTheaterById(theater.getId());
        return "delete-success";
    }
}
