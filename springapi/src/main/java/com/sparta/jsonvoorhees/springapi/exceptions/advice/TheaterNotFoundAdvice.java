package com.sparta.jsonvoorhees.springapi.exceptions.advice;

import com.sparta.jsonvoorhees.springapi.exceptions.TheaterNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TheaterNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TheaterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String theaterNotFoundHandler(TheaterNotFoundException e){
        return e.getMessage();
    }
}
