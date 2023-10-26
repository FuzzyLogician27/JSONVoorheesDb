package com.sparta.jsonvoorhees.springapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TheaterExistsAdvice {

    @ResponseBody
    @ExceptionHandler(TheaterExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String theaterExistsHandler(TheaterExistsException e){
        return e.getMessage();
    }

}
