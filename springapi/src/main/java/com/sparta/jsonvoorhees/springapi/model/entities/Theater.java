package com.sparta.jsonvoorhees.springapi.model.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("theaters")
public class Theater {

  private String id;
  private Location location;
  private long theaterId;



  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public long getTheaterId() {
    return theaterId;
  }

  public void setTheaterId(long theaterId) {
    this.theaterId = theaterId;
  }




}
