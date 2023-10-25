package com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects;

import java.util.ArrayList;

public class Geo {
    private String type;
    private ArrayList<Double> coordinates;

    public Geo() {}

    public Geo(String type, ArrayList<Double> coordinates) {
        this.type = type;
        this.coordinates=coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return type+", "+coordinates;
    }
}
