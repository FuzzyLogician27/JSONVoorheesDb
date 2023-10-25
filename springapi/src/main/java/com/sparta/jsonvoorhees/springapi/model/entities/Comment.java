package com.sparta.jsonvoorhees.springapi.model.entities;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("comments")
public class Comment {

  @Id
  private String id;
  private java.util.Date date;
  private String email;
  @Field("movie_id")
  private ObjectId movieId;
  private String name;
  private String text;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public java.util.Date getDate() {
    return date;
  }

  public void setDate(java.util.Date date) {
    this.date = date;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public ObjectId getMovieId() {
    return movieId;
  }

  public void setMovieId(ObjectId movieId) {
    this.movieId = movieId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

}
