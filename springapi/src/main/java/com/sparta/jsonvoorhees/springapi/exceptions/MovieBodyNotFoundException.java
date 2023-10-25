package com.sparta.jsonvoorhees.springapi.exceptions;

public class MovieBodyNotFoundException extends Exception {

    public MovieBodyNotFoundException(){
        super("Movie title empty. ");
    }
}
