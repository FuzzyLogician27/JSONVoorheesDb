package com.sparta.jsonvoorhees.springapi.model.entities.dtos;

import org.bson.types.ObjectId;

public class MovieCommentsDTO {
    private String id;
    private java.util.Date date;
    private String email;
    private ObjectId movie_id;
    private String name;
    private String text;
}
