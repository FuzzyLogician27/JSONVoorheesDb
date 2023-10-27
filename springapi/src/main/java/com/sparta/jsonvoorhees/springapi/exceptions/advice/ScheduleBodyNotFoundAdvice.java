package com.sparta.jsonvoorhees.springapi.exceptions.advice;

import com.sparta.jsonvoorhees.springapi.exceptions.ScheduleBodyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ScheduleBodyNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ScheduleBodyNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String scheduleBodyNotFoundHandler(ScheduleBodyNotFoundException e){
        return e.getMessage();
    }
}
