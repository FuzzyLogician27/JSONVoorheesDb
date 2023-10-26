package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Controller
public class MovieWebController {
    private final ServiceLayer serviceLayer;

    public MovieWebController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/web/movies")
    public String getAllMovies(Model model,
                               @RequestParam(name = "title", required = false) String title,
                               @RequestParam(name="page", required = false) Optional<Integer> page,
                               @RequestParam(name="pageSize", required = false) Optional<Integer> pageSize) {

        model.addAttribute("movies", serviceLayer.getAllMoviesWithTitle(title,
                PageRequest.of(
                        page.orElse(1)-1,
                        pageSize.orElse(50))));
        return "/movies/movies";
    }

    @GetMapping("/web/movie/{id}")
    public String getMovieById(Model model, @PathVariable String id) {
        model.addAttribute("movie", serviceLayer.getMovieById(id).get());
        model.addAttribute("comments",serviceLayer.getCommentsByMovie(id));

        Comment comment = new Comment();
        ObjectId objId = new ObjectId(id);
        comment.setMovieId(objId);
        model.addAttribute("commentToCreate",comment);
        return "movies/movie";
    }

    @PostMapping("/web/movie/createComment/{movieId}")
    public String createComment(Model model, @PathVariable String movieId, @ModelAttribute("commentToCreate") Comment comment) {
        model.addAttribute("movie", serviceLayer.getMovieById(movieId));
        comment.setDate(Date.from(Instant.now()));
        serviceLayer.addComment(comment);
        return "movies/comment-added";
    }

    @GetMapping("/web/movie/create")
    public String getCreateForm(Model model) {
        model.addAttribute("movieToCreate",new Movie());
        return "movies/movie-create-form";
    }

    @PostMapping("/web/createMovie")
    public String createMovie(@ModelAttribute("movieToCreate") Movie movie) {
        serviceLayer.addMovie(movie);
        return "create-success";
    }

    @GetMapping("/web/movie/edit/{id}")
    public String getEditForm(Model model, @PathVariable String id) {
        model.addAttribute("movieToEdit", serviceLayer.getMovieById(id).orElse(null));
        return "movies/movie-edit-form";
    }

    @PostMapping("/web/updateMovie")
    public String updateMovie(@ModelAttribute("movieToEdit") Movie movie) {
        Movie existingMovie = serviceLayer.getMovieById(movie.getId()).get();
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setFullplot(movie.getFullplot());
        existingMovie.setGenres(movie.getGenres());
        existingMovie.setRated(movie.getRated());
        existingMovie.setYear(movie.getYear());
        serviceLayer.updateMovie(existingMovie);
        return "edit-success";
    }

    @GetMapping("/web/movie/delete/{id}")
    public String getDeleteForm(Model model, @PathVariable String id) {
        model.addAttribute("movieToDelete", serviceLayer.getMovieById(id).orElse(null));
        return "movies/movie-delete-form";
    }

    @PostMapping("/web/deleteMovie")
    public String deleteMovie(@ModelAttribute("movieToDelete") Movie movie) {
        serviceLayer.deleteMovieById(movie.getId());
        return "delete-success";
    }
}
