package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.exceptions.CommentNotFoundException;
import com.sparta.jsonvoorhees.springapi.exceptions.MovieNotFoundException;
import com.sparta.jsonvoorhees.springapi.exceptions.UserNotFoundException;
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
    public List<Comment> getAllCommentsByMovieId(@PathVariable String movieId) throws MovieNotFoundException {
        Optional<Movie> movieById = serviceLayer.getMovieById(movieId);
        if (movieById.isEmpty()){
            throw new MovieNotFoundException(movieId);
        }
        return serviceLayer.getCommentsByMovie(movieId);
    }

    @GetMapping("/api/comments/getAllCommentsByUserId/{userId}")
    public List<Comment> getAllCommentsByUserId(@PathVariable String userId) throws UserNotFoundException{
        Optional<User> userById = serviceLayer.getUserById(userId);
        if (userById.isEmpty()){
            throw new UserNotFoundException(userId);
        }
        return serviceLayer.getCommentsByUser(userId);
    }

    @GetMapping("/api/comments/getComment/{id}")
    public Optional<Comment> getCommentById(@PathVariable String id) throws CommentNotFoundException
    {
        Optional<Comment> commentById = serviceLayer.getCommentById(id);
        if (commentById.isEmpty()){
            throw new CommentNotFoundException(id);
        }
        return commentById;
    }

    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody Comment comment) {
        return serviceLayer.addComment(comment);
    }

    @DeleteMapping("/api/comments/{id}")
    public String deleteComment(@PathVariable String id) throws CommentNotFoundException{
        Optional<Comment> commentById = serviceLayer.getCommentById(id);
        if (commentById.isEmpty()){
            throw new CommentNotFoundException(id);
        }
        return serviceLayer.deleteCommentById(id);
    }

    @PatchMapping("/api/comments/{id}")
    public Comment updateComment(@RequestBody Comment comment, @PathVariable String id) throws CommentNotFoundException {
        Optional<Comment> commentById = serviceLayer.getCommentById(id);
        if (commentById.isEmpty()){
            throw new CommentNotFoundException(id);
        }
        return serviceLayer.updateComment(comment);
    }

}
