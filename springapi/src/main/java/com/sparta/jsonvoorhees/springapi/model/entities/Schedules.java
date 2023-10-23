package com.sparta.jsonvoorhees.springapi.model.entities;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("schedules")
public class Schedules {
    private String id;
    private Date date;
    private String movieId;
    private String theaterId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }
}
