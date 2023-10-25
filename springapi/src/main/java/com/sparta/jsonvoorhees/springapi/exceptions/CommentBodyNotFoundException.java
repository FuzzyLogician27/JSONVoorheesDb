package com.sparta.jsonvoorhees.springapi.exceptions;

public class CommentBodyNotFoundException extends Exception {

    public CommentBodyNotFoundException(){
        super("Comment body empty.");
    }
}
