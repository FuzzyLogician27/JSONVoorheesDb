package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.exceptions.MovieBodyNotFoundException;
import com.sparta.jsonvoorhees.springapi.exceptions.MovieNotFoundException;
import com.sparta.jsonvoorhees.springapi.exceptions.MovieTitleNotFoundException;
import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieApiController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public MovieApiController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/api/movies/getMovies")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getMovies(@RequestParam(name = "query", required = false)String query) throws MovieTitleNotFoundException{
        List<Movie> allMoviesWithTitle = serviceLayer.getAllMoviesWithTitle(query);
        if (allMoviesWithTitle.isEmpty()){
            throw new MovieTitleNotFoundException(query);
        }
        return allMoviesWithTitle;
    }

    @GetMapping("/api/movies/getMovie/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Movie> getMovieById(@PathVariable String id) throws MovieNotFoundException {
        Optional<Movie> movieById = serviceLayer.getMovieById(id);
        if (movieById.isEmpty()){
            throw new MovieNotFoundException(id);
        }
        return movieById;
    }

    @PostMapping("/api/movies")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie) throws MovieBodyNotFoundException {
        if(movie.getTitle().isEmpty()) {
            throw new MovieBodyNotFoundException();
        }
        return serviceLayer.addMovie(movie);
    }

    @DeleteMapping("/api/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteMovie(@PathVariable String id) throws MovieNotFoundException{
        Optional<Movie> movieById = serviceLayer.getMovieById(id);
        if (movieById.isEmpty()){
            throw new MovieNotFoundException(id);
        }
        return serviceLayer.deleteMovieById(id);
    }

    @PatchMapping("/api/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable String id) throws MovieNotFoundException{
        Optional<Movie> movieById = serviceLayer.getMovieById(id);
        if (movieById.isEmpty()){
            throw new MovieNotFoundException(id);
        }
        return serviceLayer.updateMovie(movie);
    }

    @GetMapping("/api/movies/getMovies/filter")
    @ResponseStatus(HttpStatus.OK)
    public Page<Movie> filterBooks(@RequestParam(name = "query", required = false) String query, @ParameterObject Pageable pageable) throws MovieTitleNotFoundException {
        Page<Movie> allMoviesWithTitle = serviceLayer.getAllMoviesWithTitle(query, pageable);
        if (allMoviesWithTitle.isEmpty()) {
            throw new MovieTitleNotFoundException(query);
        }
        return allMoviesWithTitle;
    }

}
