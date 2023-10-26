package com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects;

import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.entities.Schedule;

public class ScheduleVM {
    private Schedule schedule;
    private Movie movie;

    public ScheduleVM() {
        schedule = new Schedule();
        movie = new Movie();
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
