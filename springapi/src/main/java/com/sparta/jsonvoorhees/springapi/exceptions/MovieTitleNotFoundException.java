package com.sparta.jsonvoorhees.springapi.exceptions;

public class MovieTitleNotFoundException extends Exception{
    public MovieTitleNotFoundException(String title){
        super("Could not find movies with title: " + title);
    }
}
