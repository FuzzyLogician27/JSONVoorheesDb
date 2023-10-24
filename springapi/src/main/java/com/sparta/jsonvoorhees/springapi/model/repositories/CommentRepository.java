package com.sparta.jsonvoorhees.springapi.model.repositories;

import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import org.bson.types.ObjectId;
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

    //@Query(value = "select * from authors where full_Name like ?1%",nativeQuery = true)
    //@Query(value="{movieId: 573a1391f29313caabcd7a34}")
    //@Query("{'movieId' : ?0}")
    List<Comment> findCommentByMovieId(ObjectId movieId);
    List<Comment> findCommentsByNameContains(String name);

}
