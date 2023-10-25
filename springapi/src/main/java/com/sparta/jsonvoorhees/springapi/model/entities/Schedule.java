package com.sparta.jsonvoorhees.springapi.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("schedules")
public class Schedule {

  @Id
  private String id;
  private String date;
  private String movieId;
  private String theaterId;

  public Schedule() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
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
