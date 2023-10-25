package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.entities.Theater;
import com.sparta.jsonvoorhees.springapi.model.entities.User;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TheatreApiController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public TheatreApiController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/api/theatres/getTheatres")
    public List<Theater> getAllTheatres() {
        return serviceLayer.getAllTheaters();
    }

    @GetMapping("/api/theatres/getTheatre/{id}")
    public Optional<Theater> getTheaterById(@PathVariable String id) {
        return serviceLayer.getTheaterById(id);
    }

//    @PostMapping("/api/theaters")
//    public String createTheater(@RequestBody Theater theater) {
//        return serviceLayer.createTheater(theater);
//    }
//
//    @DeleteMapping("/api/theaters/{id}")
//    public String deleteTheater(@PathVariable String id) {
//        return serviceLayer.deleteTheater(id);
//    }
//
//    @PatchMapping("/api/theaters/{id}")
//    public Movie updateTheater(@RequestBody Theater theater, @PathVariable Integer id) {
//        return serviceLayer.updateTheater(id, theater);
//    }

}
