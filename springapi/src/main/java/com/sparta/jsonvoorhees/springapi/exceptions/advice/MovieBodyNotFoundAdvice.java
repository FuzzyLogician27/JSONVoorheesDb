package com.sparta.jsonvoorhees.springapi.exceptions.advice;

import com.sparta.jsonvoorhees.springapi.exceptions.MovieBodyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MovieBodyNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MovieBodyNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String movieBodyNotFoundHandler(MovieBodyNotFoundException e){
        return e.getMessage();
    }
}
