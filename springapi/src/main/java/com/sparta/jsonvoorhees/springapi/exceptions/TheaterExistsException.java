package com.sparta.jsonvoorhees.springapi.exceptions;

public class TheaterExistsException extends Exception {

    public TheaterExistsException(String theaterId){
        super("Theater matching id " + theaterId + " already exists.");
    }
}
