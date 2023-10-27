package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WebErrorControllerAdvice {
    @ExceptionHandler(TheaterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String theaterNotFoundException(TheaterNotFoundException e, Model model){
        model.addAttribute("message", e.getMessage());
        return "error/error-404";
    }

    @ExceptionHandler(TheaterBodyNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String theaterBodyNotFoundException(TheaterBodyNotFoundException e, Model model){
        model.addAttribute("message", e.getMessage());
        return "error/error-400";
    }
    @ExceptionHandler(TheaterExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String theaterExistsException(TheaterExistsException e, Model model){
        model.addAttribute("message", e.getMessage());
        return "error/error-400";
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundException(UserNotFoundException e, Model model){
        model.addAttribute("message", e.getMessage());
        return "error/error-404";
    }

    @ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String movieNotFoundException(MovieNotFoundException e, Model model){
        model.addAttribute("message", e.getMessage());
        return "error/error-404";
    }

    @ExceptionHandler(MovieBodyNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String movieBodyNotFoundException(MovieBodyNotFoundException e, Model model){
        model.addAttribute("message", e.getMessage());
        return "error/error-400";
    }
}
