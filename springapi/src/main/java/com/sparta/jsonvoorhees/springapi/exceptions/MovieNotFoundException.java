package com.sparta.jsonvoorhees.springapi.exceptions;

public class MovieNotFoundException extends Exception{

    public MovieNotFoundException(String id){
        super("Could not find movie with id: " + id);
    }
}
