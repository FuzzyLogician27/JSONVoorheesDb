package com.sparta.jsonvoorhees.springapi.service;

import com.sparta.jsonvoorhees.springapi.model.entities.*;
import com.sparta.jsonvoorhees.springapi.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IServiceLayer {

    public List<Movie> getAllMoviesWithTitle(String title);
    public Page<Movie> getAllMoviesWithTitle(String title, Pageable pageRequest);

    public List<Schedule> getSchedulesForTheaters(String theaterId);

    public List<Comment> getCommentsByMovie(String movieId);

    public List<Comment> getCommentsByUser(String name);

    public Optional<Movie> getMovieById(String movieId);

    public Optional<Theater> getTheaterById(String theaterId);
    public Optional<Theater> getTheaterByTheaterId(Long theaterId);

    public Optional<Schedule> getScheduleById(String scheduleId);

    public Optional<User> getUserById(String userId);

    public Optional<Comment> getCommentById(String commentId);

    public List<User> getAllUsers();
    public Page<User> getAllUsers(Pageable pageRequest );

    public List<Schedule> getAllSchedules();
    public Page<Schedule> getAllSchedules(Pageable pageRequest);

    public List<Comment> getAllComments();
    public Page<Comment> getAllComments(Pageable pageRequest);

    public List<Theater> getAllTheaters();
    public Page<Theater> getAllTheaters(Pageable pageRequest);

    public Comment updateComment(Comment newComment);

    public Movie updateMovie(Movie newMovie);

    public Schedule updateSchedule(Schedule newSchedule);

    public Theater updateTheater(Theater newTheater);

    public User updateUser(User newUser);

    public String deleteCommentById(String id);

    public String deleteMovieById(String id);

    public String deleteScheduleById(String id);

    public String deleteTheaterById(String id);

    public String deleteUserById(String id);

    public Comment addComment(Comment newComment);

    public Movie addMovie(Movie newMovie);

    public Schedule addSchedule(Schedule newSchedule);

    public Theater addTheater(Theater newTheater);

    public User addUser(User newUser);

    public void addComments(List<Comment> newComments);

    public void addMovies(List<Movie> newMovies);

    public void addSchedules(List<Schedule> newSchedules);

    public void addTheaters(List<Theater> newTheaters);

    public void addUsers(List<User> newUsers);
}