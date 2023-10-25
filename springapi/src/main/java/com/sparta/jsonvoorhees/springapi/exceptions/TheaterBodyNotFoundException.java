package com.sparta.jsonvoorhees.springapi.exceptions;

public class TheaterBodyNotFoundException extends Exception {

    public TheaterBodyNotFoundException(){
        super("Theater missing TheaterId.");
    }
}
