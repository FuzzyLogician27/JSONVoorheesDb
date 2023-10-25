package com.sparta.jsonvoorhees.springapi.service;

import com.sparta.jsonvoorhees.springapi.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiLibraryService{
    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;

    private final TheaterRepository theaterRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Autowired
    public ApiLibraryService(CommentRepository commentRepository,
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

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public ScheduleRepository getScheduleRepository() {
        return scheduleRepository;
    }

    public TheaterRepository getTheaterRepository() {
        return theaterRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    //Only methods that we need here are cross-repo methods?
}
