package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.repositories.MovieRepository;
import com.sparta.jsonvoorhees.springapi.service.ApiLibraryService;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Movie> getMovies(@RequestParam(name = "query", required = false)String query) {
        return serviceLayer.getAllMoviesWithTitle(query);
    }

    @GetMapping("/api/movies/getMovie/{id}")
    public Optional<Movie> getMovieById(@PathVariable String id) {
        return serviceLayer.getMovieById(id);
    }

    @PostMapping("/api/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return serviceLayer.addMovie(movie);
    }

    @DeleteMapping("/api/movies/{id}")
    public String deleteMovie(@PathVariable String id) {
        return serviceLayer.deleteMovieById(id);
    }

    @PatchMapping("/api/movies/{id}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable String id) {
        return serviceLayer.updateMovie(id, movie);
    }

}
