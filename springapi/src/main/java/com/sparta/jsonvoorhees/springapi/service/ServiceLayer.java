package com.sparta.jsonvoorhees.springapi.service;

import com.sparta.jsonvoorhees.springapi.model.entities.*;
import com.sparta.jsonvoorhees.springapi.model.repositories.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceLayer {
    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Autowired
    public ServiceLayer(CommentRepository commentRepository,
                             MovieRepository movieRepository,
                             ScheduleRepository scheduleRepository,
                             TheaterRepository theaterRepository,
                             UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.movieRepository = movieRepository;
        this.scheduleRepository = scheduleRepository;
        this.theaterRepository = theaterRepository;
        this.userRepository = userRepository;
    }

    public List<Movie> getAllMoviesWithTitle(String title) {
        List<Movie> fullMovieList = movieRepository.findAll();
        if (title == null) {
            return movieRepository.findAll();
        }
        else {
            List<Movie> filteredMovies = new ArrayList<>();
            for (Movie movie : fullMovieList) {
                if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    filteredMovies.add(movie);
                }
            }
            return filteredMovies;
        }
    }

    public List<Schedule> getSchedulesForTheaters(String theaterId)
    {
        return scheduleRepository.findSchedulesByTheaterId(theaterId);
    }

    //public List<Author> findAuthorsWithMoreThanOneBook() {
    //    ArrayList<Author> popularAuthors = new ArrayList<>();
    //    for(Author author: authorRepository.findAll()) {
    //        if(author.getBookSet().size() > 1) {
    //            popularAuthors.add(author);
    //        }
    //    }
    //    return popularAuthors;
    //}

    public List<Comment> getCommentsByMovie(ObjectId movieId)
    {
        //System.out.println(commentRepository.findByMovieId(movieId).size());
        return commentRepository.findCommentByMovieId(movieId);

    }

    public List<Comment> getCommentsByUser(String name)
    {
        return commentRepository.findCommentsByNameContains(name);
    }

    public List<Theater> getAllTheaters()
    {
        return theaterRepository.findAll();
    }

    //region Basic Getters
    public Optional<Movie> getMovieById(ObjectId movieId)
    {
        return movieRepository.findMovieById(movieId);
    }

    public Optional<Theater> getTheaterById(String theaterId)
    {
        //@TODO: Check this one
        return theaterRepository.findTheaterByTheaterId(Long.valueOf(theaterId));
    }

    public Optional<Schedule> getScheduleById(String scheduleId)
    {
        return scheduleRepository.findScheduleById(scheduleId);
    }

    public Optional<User> getUserById(String userId)
    {
        return userRepository.findUserById(userId);
    }

    public Optional<Comment> getCommentById(String commentId)
    {
        return commentRepository.findCommentById(commentId);
    }
    //endregion


}
