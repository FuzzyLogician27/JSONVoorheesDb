package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.exceptions.MovieBodyNotFoundException;
import com.sparta.jsonvoorhees.springapi.exceptions.MovieNotFoundException;
import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
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
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getMovieById(Model model, @PathVariable String id) throws MovieNotFoundException {
        Optional<Movie> movieById = serviceLayer.getMovieById(id);
        if (movieById.isEmpty()){
            throw new MovieNotFoundException(id);
        }
        model.addAttribute("movie", movieById.get());
        model.addAttribute("comments",serviceLayer.getCommentsByMovie(id));

        Comment comment = new Comment();
        ObjectId objId = new ObjectId(id);
        comment.setMovieId(objId);
        model.addAttribute("commentToCreate",comment);
        return "movies/movie";
    }

    @PostMapping("/web/movie/createComment/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String createComment(Model model, @PathVariable String id,
                                @ModelAttribute("commentToCreate") Comment comment) throws MovieNotFoundException{
        Optional<Movie> movieById = serviceLayer.getMovieById(id);
        if (movieById.isEmpty()){
            throw new MovieNotFoundException(id);
        }
        model.addAttribute("movie", movieById.get());
        comment.setDate(Date.from(Instant.now()));
        serviceLayer.addComment(comment);
        return "movies/comment-added";
    }

    @GetMapping("/web/movie/create")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getCreateForm(Model model) {
        model.addAttribute("movieToCreate",new Movie());
        return "movies/movie-create-form";
    }

    @PostMapping("/web/createMovie")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createMovie(@ModelAttribute("movieToCreate") Movie movie) throws MovieBodyNotFoundException {
        if(movie.getTitle().isEmpty()) {
            throw new MovieBodyNotFoundException();
        }
        serviceLayer.addMovie(movie);
        return "create-success";
    }

    @GetMapping("/web/movie/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getEditForm(Model model, @PathVariable String id) throws MovieNotFoundException{
        Optional<Movie> movieById = serviceLayer.getMovieById(id);
        if (movieById.isEmpty()){
            throw new MovieNotFoundException(id);
        }
        model.addAttribute("movieToEdit", movieById.get());
        return "movies/movie-edit-form";
    }

    @PostMapping("/web/updateMovie")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getDeleteForm(Model model, @PathVariable String id) throws MovieNotFoundException{
        Optional<Movie> movieById = serviceLayer.getMovieById(id);
        if (movieById.isEmpty()){
            throw new MovieNotFoundException(id);
        }
        model.addAttribute("movieToDelete", movieById.get());
        return "movies/movie-delete-form";
    }

    @PostMapping("/web/deleteMovie")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteMovie(@ModelAttribute("movieToDelete") Movie movie) {
        serviceLayer.deleteMovieById(movie.getId());
        return "delete-success";
    }
}
