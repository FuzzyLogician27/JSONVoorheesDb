package com.sparta.jsonvoorhees.springapi.exceptions;

public class TheaterNotFoundException extends Exception {
    public TheaterNotFoundException(String id){
        super("Could not find theater with id: " + id);
    }
}
