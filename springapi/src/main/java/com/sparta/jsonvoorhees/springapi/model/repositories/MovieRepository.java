package com.sparta.jsonvoorhees.springapi.model.repositories;


import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> findMovieById(ObjectId id);
    Optional<Movie> findMovieByTitle(String title);

    List<Movie> findMoviesByTitleContains(String title);
    List<Movie> findMoviesByReleased(Date released);
    List<Movie> findMoviesByRated(String rated);
    List<Movie> findMoviesByGenresContains(String genre);

}
