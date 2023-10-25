package com.sparta.jsonvoorhees.springapi.exceptions;

public class UserBodyNotFoundException extends Exception {

    public UserBodyNotFoundException(){
        super("User body missing fields.");
    }
}
