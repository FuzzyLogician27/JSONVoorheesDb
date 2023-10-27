package com.sparta.jsonvoorhees.springapi.exceptions.advice;

import com.sparta.jsonvoorhees.springapi.exceptions.MovieTitleNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MovieTitleNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MovieTitleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String movieTitleNotFoundHandler(MovieTitleNotFoundException e){
        return e.getMessage();
    }
}
