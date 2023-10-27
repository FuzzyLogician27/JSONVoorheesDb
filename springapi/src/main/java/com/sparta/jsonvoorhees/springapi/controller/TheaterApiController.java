package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.exceptions.*;
import com.sparta.jsonvoorhees.springapi.model.entities.Theater;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TheaterApiController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public TheaterApiController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/api/theaters")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Theater> getAllTheatres() {
        return serviceLayer.getAllTheaters();
    }

    @GetMapping("/api/theaters/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Optional<Theater> getTheaterById(@PathVariable String id) throws TheaterNotFoundException {
        Optional<Theater> theaterById = serviceLayer.getTheaterById(id);
        if (theaterById.isEmpty()){
            throw new TheaterNotFoundException(id);
        }
        return serviceLayer.getTheaterById(id);
    }

    @PostMapping("/api/theaters")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Theater createTheater(@RequestBody Theater theater) throws TheaterBodyNotFoundException, TheaterExistsException {
        String theaterIdString = "" + theater.getTheaterId();
        if (theaterIdString.isEmpty()){
            throw new TheaterBodyNotFoundException();
        } else if (serviceLayer.getTheaterByTheaterId(theater.getTheaterId()).isPresent()) {
            throw new TheaterExistsException(theaterIdString);
        }
        return serviceLayer.addTheater(theater);
    }


    @DeleteMapping("/api/theaters/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteTheater(@PathVariable String id) throws TheaterNotFoundException{
        Optional<Theater> theaterById = serviceLayer.getTheaterById(id);
        if (theaterById.isEmpty()){
            throw new TheaterNotFoundException(id);
        }
        return serviceLayer.deleteTheaterById(id);
    }

    @PatchMapping("/api/theaters/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Theater updateTheater(@RequestBody Theater theater, @PathVariable String id)  throws TheaterNotFoundException{
        Optional<Theater> theaterById = serviceLayer.getTheaterById(id);
        if (theaterById.isEmpty()){
            throw new TheaterNotFoundException(id);
        }
        return serviceLayer.updateTheater(theater);
    }

}
