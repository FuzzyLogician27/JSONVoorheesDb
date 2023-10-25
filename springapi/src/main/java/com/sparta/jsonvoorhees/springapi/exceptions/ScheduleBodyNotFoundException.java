package com.sparta.jsonvoorhees.springapi.exceptions;

public class ScheduleBodyNotFoundException extends Exception {

    public ScheduleBodyNotFoundException(){
        super("Schedule missing movieId or theaterId");
    }
}
