package com.sparta.jsonvoorhees.springapi.model.repositories;

import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    Optional<Comment> findCommentById(String id);

    List<Comment> findCommentsByEmail(String email);
    List<Comment> findCommentsByDate(Date date);

    //@Query(value="{movieId: 573a1391f29313caabcd7a34}")
    //@Query("{'movieId' : ?0}")
    //List<Comment> findByMovie(Movie movie);

    List<Comment> findCommentsByMovieId(String movieId);
    List<Comment> findCommentsByNameContains(String name);

}
