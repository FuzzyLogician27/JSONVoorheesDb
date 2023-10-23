package com.sparta.jsonvoorhees.springapi.model.repositories;

import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    Optional<Comment> findCommentById(String id);

    List<Comment> findCommentsByEmail(String email);
    List<Comment> findCommentsByDate(Date date);
    List<Comment> findCommentsByMovieId(String movieId);
    List<Comment> findCommentsByNameContains(String name);

}
