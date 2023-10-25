package com.sparta.jsonvoorhees.springapi.model.repositories;

import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    Page<Comment> findCommentsByEmail(String email, Pageable pageable);
    List<Comment> findCommentsByDate(Date date);
    Page<Comment> findCommentsByDate(Date date, Pageable pageable);

    //@Query(value="{movieId: 573a1391f29313caabcd7a34}")
    //@Query("{'movieId' : ?0}")
    //List<Comment> findByMovie(Movie movie);
    @Query("{movie_id: ObjectId('?0')}")
    List<Comment> findCommentsByMovieId(String movieId );
    @Query("{movie_id: ObjectId('?0')}")
    Page<Comment> findCommentsByMovieId(String movieId , Pageable pageable);
    List<Comment> findCommentsByNameContains(String name);
    List<Comment> findCommentsByNameContains(String name, Pageable pageable);

}
