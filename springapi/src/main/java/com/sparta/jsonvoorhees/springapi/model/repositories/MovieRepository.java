package com.sparta.jsonvoorhees.springapi.model.repositories;


import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    Optional<Movie> findMovieById(String id);
    Optional<Movie> findMovieByTitle(String title);

    List<Movie> findMoviesByTitleContainsIgnoreCase(String title);
    Page<Movie> findMoviesByTitleContainsIgnoreCase(String title, Pageable pageable);
    List<Movie> findMoviesByReleased(Date released);
    Page<Movie> findMoviesByReleased(Date released, Pageable pageable);
    List<Movie> findMoviesByRated(String rated);
    List<Movie> findMoviesByRated(String rated, Pageable pageable);
    List<Movie> findMoviesByGenresContains(String genre);
    Page<Movie> findMoviesByGenresContains(String genre, Pageable pageable);

}
