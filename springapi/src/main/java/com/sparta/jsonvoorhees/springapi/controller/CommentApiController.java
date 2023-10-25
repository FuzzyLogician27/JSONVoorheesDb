package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.entities.User;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentApiController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public CommentApiController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/api/comments/getAllCommentsByMovieId/{movieId}")
    public List<Comment> getAllCommentsByMovieId(@PathVariable String movieId) {
        return serviceLayer.getCommentsByMovie(movieId);
    }

    @GetMapping("/api/comments/getAllCommentsByUserId/{userId}")
    public List<Comment> getAllCommentsByUserId(@PathVariable String userId) {
        return serviceLayer.getCommentsByUser(userId);
    }

    @GetMapping("/api/comments/getComment/{id}")
    public Optional<Comment> getCommentById(@PathVariable String id) {
        return serviceLayer.getCommentById(id);
    }

    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody Comment comment) {
        return serviceLayer.addComment(comment);
    }

    @DeleteMapping("/api/comments/{id}")
    public String deleteComment(@PathVariable String id) {
        return serviceLayer.deleteCommentById(id);
    }

    @PatchMapping("/api/comments/{id}")
    public Comment updateComment(@RequestBody Comment comment, @PathVariable String id) {
        return serviceLayer.updateComment(id, comment);
    }

}
