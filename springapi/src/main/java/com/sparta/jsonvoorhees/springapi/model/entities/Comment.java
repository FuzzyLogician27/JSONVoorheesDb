package com.sparta.jsonvoorhees.springapi.model.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Document("comments")
public class Comment {

  @Id
  private String id;
  private java.util.Date date;
  private String email;

  @JsonProperty("movie_id")
  @BsonIgnore
  private ObjectId movie_id;

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
    return movie_id;
  }

  public void setMovieId(ObjectId movieId) {
    this.movie_id = movieId;
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
