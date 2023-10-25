package com.sparta.jsonvoorhees.springapi.exceptions;

public class CommentNotFoundException extends Exception {
    public CommentNotFoundException(String id){
        super("Could not find comment with id: " + id);
    }
}
