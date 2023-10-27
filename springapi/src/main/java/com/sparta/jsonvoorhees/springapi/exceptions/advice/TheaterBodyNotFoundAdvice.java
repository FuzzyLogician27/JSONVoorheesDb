package com.sparta.jsonvoorhees.springapi.exceptions.advice;

import com.sparta.jsonvoorhees.springapi.exceptions.TheaterBodyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TheaterBodyNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TheaterBodyNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String theaterBodyNotFoundHandler(TheaterBodyNotFoundException e){
        return e.getMessage();
    }
}
