package com.sparta.jsonvoorhees.springapi.exceptions;

public class ScheduleNotFoundException extends Exception {
    public ScheduleNotFoundException(String id){
        super("Could not find schedule with id: " + id);
    }
}
