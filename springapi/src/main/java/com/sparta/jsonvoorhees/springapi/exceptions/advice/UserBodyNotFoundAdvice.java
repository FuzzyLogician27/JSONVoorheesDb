package com.sparta.jsonvoorhees.springapi.exceptions.advice;


import com.sparta.jsonvoorhees.springapi.exceptions.UserBodyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserBodyNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UserBodyNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userBodyNotFoundHandler(UserBodyNotFoundException e){
        return e.getMessage();
    }
}
