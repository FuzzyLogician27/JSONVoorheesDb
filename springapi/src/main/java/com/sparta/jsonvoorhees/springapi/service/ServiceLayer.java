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
    //These appear to return the object that is saved?

    public void updateComment(Comment newComment)
    {
        commentRepository.save(newComment);
    }

    public void updateMovie(Movie newMovie)
    {
        movieRepository.save(newMovie);
    }

    public void updateSchedule(Schedule newSchedule)
    {
        scheduleRepository.save(newSchedule);
    }

    public void updateTheater(Theater newTheater)
    {
        theaterRepository.save(newTheater);
    }

    public void updateUser(User newUser)
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

    //region Deleters
    public void deleteCommentById(String id)
    {
        commentRepository.deleteById(id);
    }

    public void deleteMovieById(String id)
    {
        movieRepository.deleteById(id);
    }

    public void deleteScheduleById(String id)
    {
        scheduleRepository.deleteById(id);
    }

    public void deleteTheaterById(String id)
    {
        theaterRepository.deleteById(id);
    }

    //@Todo This is still up for debate
    public void deleteUserById(String id)
    {
        userRepository.deleteById(id);
    }
    //endregion

    //region Creators
    //Some of these are the same as the savers, as a save with new data adds it

    public void addComment(Comment newComment)
    {
        commentRepository.save(newComment);
    }

    public void addMovie(Movie newMovie)
    {
        movieRepository.save(newMovie);
    }

    public void addSchedule(Schedule newSchedule)
    {
        scheduleRepository.save(newSchedule);
    }

    public void addTheater(Theater newTheater)
    {
        theaterRepository.save(newTheater);
    }

    public void addUser(User newUser)
    {
        userRepository.save(newUser);
    }

    public void addComments(List<Comment> newComments)
    {
        commentRepository.insert(newComments);
    }

    public void addMovies(List<Movie> newMovies)
    {
        movieRepository.insert(newMovies);
    }

    public void addSchedules(List<Schedule> newSchedules)
    {
        scheduleRepository.insert(newSchedules);
    }

    public void addTheaters(List<Theater> newTheaters)
    {
        theaterRepository.insert(newTheaters);
    }

    public void addUsers(List<User> newUsers)
    {
        userRepository.insert(newUsers);
    }
    //endregion
}
