package com.sparta.jsonvoorhees.springapi.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("theaters")
public class Theater {

  @Id
  private String id;
  private String location;
  private long theaterId;
  private String location_Address;
  private String location_Address_City;
  private String location_Address_State;
  private String location_Address_Street1;
  private String location_Address_Zipcode;
  private String location_Geo;
  private String location_Geo_Coordinates;
  private String location_Geo_Type;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public long getTheaterId() {
    return theaterId;
  }

  public void setTheaterId(long theaterId) {
    this.theaterId = theaterId;
  }


  public String getLocation_Address() {
    return location_Address;
  }

  public void setLocation_Address(String location_Address) {
    this.location_Address = location_Address;
  }


  public String getLocation_Address_City() {
    return location_Address_City;
  }

  public void setLocation_Address_City(String location_Address_City) {
    this.location_Address_City = location_Address_City;
  }


  public String getLocation_Address_State() {
    return location_Address_State;
  }

  public void setLocation_Address_State(String location_Address_State) {
    this.location_Address_State = location_Address_State;
  }


  public String getLocation_Address_Street1() {
    return location_Address_Street1;
  }

  public void setLocation_Address_Street1(String location_Address_Street1) {
    this.location_Address_Street1 = location_Address_Street1;
  }


  public String getLocation_Address_Zipcode() {
    return location_Address_Zipcode;
  }

  public void setLocation_Address_Zipcode(String location_Address_Zipcode) {
    this.location_Address_Zipcode = location_Address_Zipcode;
  }


  public String getLocation_Geo() {
    return location_Geo;
  }

  public void setLocation_Geo(String location_Geo) {
    this.location_Geo = location_Geo;
  }


  public String getLocation_Geo_Coordinates() {
    return location_Geo_Coordinates;
  }

  public void setLocation_Geo_Coordinates(String location_Geo_Coordinates) {
    this.location_Geo_Coordinates = location_Geo_Coordinates;
  }


  public String getLocation_Geo_Type() {
    return location_Geo_Type;
  }

  public void setLocation_Geo_Type(String location_Geo_Type) {
    this.location_Geo_Type = location_Geo_Type;
  }

}
