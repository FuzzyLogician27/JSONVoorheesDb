package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.exceptions.ScheduleBodyNotFoundException;
import com.sparta.jsonvoorhees.springapi.exceptions.ScheduleNotFoundException;
import com.sparta.jsonvoorhees.springapi.exceptions.TheaterNotFoundException;
import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.entities.Schedule;
import com.sparta.jsonvoorhees.springapi.model.entities.Theater;
import com.sparta.jsonvoorhees.springapi.model.entities.User;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ScheduleApiController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public ScheduleApiController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/api/schedules/{theaterId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Schedule> getSchedulesByTheaterId(@PathVariable String theaterId) throws TheaterNotFoundException {
        Optional<Theater> theaterById = serviceLayer.getTheaterById(theaterId);
        if (theaterById.isEmpty()){
            throw new TheaterNotFoundException(theaterId);
        }
        return serviceLayer.getSchedulesForTheaters(theaterId);
    }

    @PostMapping("/api/schedules")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Schedule createSchedule(@RequestBody Schedule schedule) throws ScheduleBodyNotFoundException {
        if(schedule.getMovieId().isEmpty() || schedule.getTheaterId().isEmpty()) {
            throw new ScheduleBodyNotFoundException();
        }
        return serviceLayer.addSchedule(schedule);
    }

    @DeleteMapping("/api/schedules/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteSchedule(@PathVariable String id) throws ScheduleNotFoundException {
        Optional<Schedule> scheduleById = serviceLayer.getScheduleById(id);
        if (scheduleById.isEmpty()){
            throw new ScheduleNotFoundException(id);
        }
        return serviceLayer.deleteScheduleById(id);
    }

    @PatchMapping("/api/schedules/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Schedule updateUser(@RequestBody Schedule schedule, @PathVariable String id) throws ScheduleNotFoundException {
        Optional<Schedule> scheduleById = serviceLayer.getScheduleById(id);
        if (scheduleById.isEmpty()){
            throw new ScheduleNotFoundException(id);
        }
        return serviceLayer.updateSchedule(schedule);
    }
}