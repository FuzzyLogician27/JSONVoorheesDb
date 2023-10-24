package com.sparta.jsonvoorhees.springapi.service;

import com.sparta.jsonvoorhees.springapi.model.entities.*;
import com.sparta.jsonvoorhees.springapi.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Comment> getCommentsByMovie(String movieId)
    {
        return commentRepository.findCommentsByMovieId(movieId);
    }

    public List<Comment> getCommentsByUser(String name)
    {
        return commentRepository.findCommentsByNameContains(name);
    }


    //region Basic Getters
    public Optional<Movie> getMovieById(String movieId)
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

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
    
    public List<Schedule> getAllSchedules()
    {
        return scheduleRepository.findAll();
    }
    
    public List<Comment> getAllComments()
    {
        return commentRepository.findAll();
    }

    public List<Theater> getAllTheaters()
    {
        return theaterRepository.findAll();
    }

    //endregion

    //region Savers
    //@TODO: Look into having these return something to indicate success

    public void saveComment(Comment newComment)
    {
        commentRepository.save(newComment);
    }

    public void saveMovie(Movie newMovie)
    {
        movieRepository.save(newMovie);
    }

    public void saveSchedule(Schedule newSchedule)
    {
        scheduleRepository.save(newSchedule);
    }

    public void saveTheater(Theater newTheater)
    {
        theaterRepository.save(newTheater);
    }

    public void saveUser(User newUser)
    {
        userRepository.save(newUser);
    }
    //endregion

    //region Special Getters
    public List<Comment> getCommentsWithSpecifiedWords(List<String> wordsToSearchFor)
    {
        List<Comment> selectedComments = new ArrayList<Comment>();
        List<Comment> allComments = commentRepository.findAll();
        for (Comment comment:allComments)
        {
            String contents = comment.getText().toLowerCase();
            String[] wordsInContent = contents.trim().split("\\s+");
            for (String word: wordsInContent)
            {
                if (wordsToSearchFor.contains(word) && !selectedComments.contains(comment))
                {
                    selectedComments.add(comment);
                }
            }
        }
        return selectedComments;
    }
    //endregion
}
