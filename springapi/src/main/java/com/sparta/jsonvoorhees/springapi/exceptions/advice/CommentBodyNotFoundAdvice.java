package com.sparta.jsonvoorhees.springapi.exceptions.advice;

import com.sparta.jsonvoorhees.springapi.exceptions.CommentBodyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CommentBodyNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CommentBodyNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String commentBodyNotFoundHandler(CommentBodyNotFoundException e){
        return e.getMessage();
    }
}
