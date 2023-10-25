package com.sparta.jsonvoorhees.springapi.model.entities;

import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.Location;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("theaters")
public class Theater {

  @Id
  private String id;
  private long theaterId;
  private Location location;


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
