package com.sparta.jsonvoorhees.springapi.exceptions.advice;

import com.sparta.jsonvoorhees.springapi.exceptions.MovieNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MovieNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String movieNotFoundHandler(MovieNotFoundException e){
        return e.getMessage();
    }
}
