package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.exceptions.ScheduleNotFoundException;
import com.sparta.jsonvoorhees.springapi.exceptions.TheaterNotFoundException;
import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.entities.Schedule;
import com.sparta.jsonvoorhees.springapi.model.entities.Theater;
import com.sparta.jsonvoorhees.springapi.model.entities.User;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/api/schedules/getSchedule/{theaterId}")
    public List<Schedule> getSchedulesByTheaterId(@PathVariable String theaterId) throws TheaterNotFoundException {
        Optional<Theater> theaterById = serviceLayer.getTheaterById(theaterId);
        if (theaterById.isEmpty()){
            throw new TheaterNotFoundException(theaterId);
        }
        return serviceLayer.getSchedulesForTheaters(theaterId);
    }

    @PostMapping("/api/schedules")
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return serviceLayer.addSchedule(schedule);
    }

    @DeleteMapping("/api/schedules/{id}")
    public String deleteSchedule(@PathVariable String id) throws ScheduleNotFoundException {
        Optional<Schedule> scheduleById = serviceLayer.getScheduleById(id);
        if (scheduleById.isEmpty()){
            throw new ScheduleNotFoundException(id);
        }
        return serviceLayer.deleteScheduleById(id);
    }

    @PatchMapping("/api/schedules/{id}")
    public Schedule updateUser(@RequestBody Schedule schedule, @PathVariable String id) throws ScheduleNotFoundException {
        Optional<Schedule> scheduleById = serviceLayer.getScheduleById(id);
        if (scheduleById.isEmpty()){
            throw new ScheduleNotFoundException(id);
        }
        return serviceLayer.updateSchedule(schedule);
    }
}