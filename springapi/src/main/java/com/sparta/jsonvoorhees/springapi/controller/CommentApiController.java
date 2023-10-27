package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.exceptions.*;
import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.entities.User;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/api/comments/movie/{movieId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Comment> getAllCommentsByMovieId(@PathVariable String movieId) throws MovieNotFoundException {
        Optional<Movie> movieById = serviceLayer.getMovieById(movieId);
        if (movieById.isEmpty()){
            throw new MovieNotFoundException(movieId);
        }
        return serviceLayer.getCommentsByMovie(movieId);
    }

    @GetMapping("/api/comments/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Comment> getAllCommentsByUserId(@PathVariable String userId) throws UserNotFoundException{
        Optional<User> userById = serviceLayer.getUserById(userId);
        if (userById.isEmpty()){
            throw new UserNotFoundException(userId);
        }
        return serviceLayer.getCommentsByUser(userId);
    }

    @GetMapping("/api/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Optional<Comment> getCommentById(@PathVariable String id) throws CommentNotFoundException
    {
        Optional<Comment> commentById = serviceLayer.getCommentById(id);
        if (commentById.isEmpty()){
            throw new CommentNotFoundException(id);
        }
        return commentById;
    }

    @PostMapping("/api/comments")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_USER')")
    public Comment createComment(@RequestBody Comment comment) throws CommentBodyNotFoundException {
        if(comment.getText().isEmpty()) {
            throw new CommentBodyNotFoundException();
        }
        return serviceLayer.addComment(comment);
    }

    @DeleteMapping("/api/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteComment(@PathVariable String id) throws CommentNotFoundException{
        Optional<Comment> commentById = serviceLayer.getCommentById(id);
        if (commentById.isEmpty()){
            throw new CommentNotFoundException(id);
        }
        return serviceLayer.deleteCommentById(id);
    }


    // @Todo Do we want this ability?
    @PatchMapping("/api/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Comment updateComment(@RequestBody Comment comment, @PathVariable String id) throws CommentNotFoundException {
        Optional<Comment> commentById = serviceLayer.getCommentById(id);
        if (commentById.isEmpty()){
            throw new CommentNotFoundException(id);
        }
        return serviceLayer.updateComment(comment);
    }

}
