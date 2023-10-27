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

@Service
public class ServiceLayer implements IServiceLayer {
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

    //region Getters

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
    public Page<Movie> getAllMoviesWithTitle(String title, Pageable pageRequest) {
        if (title == null)
           return movieRepository.findAll(pageRequest);
        else
            return movieRepository.findMoviesByTitleContainsIgnoreCase(title, pageRequest);

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
        return theaterRepository.findTheaterById(theaterId);
    }

    public Optional<Theater> getTheaterByTheaterId(Long theaterId)
    {
        //@TODO: Check this one
        return theaterRepository.findTheaterByTheaterId(theaterId);
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
        return  userRepository.findAll();
    }
    public Page<User> getAllUsers(Pageable pageRequest )
    {
        return userRepository.findAll(pageRequest);
    }

    public Page<User> getAllUsersByName(String name, Pageable pageRequest ) {
        if (name == null)
            return userRepository.findAll(pageRequest);
        else
            return userRepository.findUsersByNameContainingIgnoreCase(name, pageRequest);
    }
    
    public List<Schedule> getAllSchedules()
    {
        return scheduleRepository.findAll();
    }
    public Page<Schedule> getAllSchedules(Pageable pageRequest)
    {
        return scheduleRepository.findAll(pageRequest);
    }

    public List<Comment> getAllComments()
    {
        return commentRepository.findAll();
    }
    public Page<Comment> getAllComments(Pageable pageRequest)
    {
        return commentRepository.findAll(pageRequest);
    }
    public List<Theater> getAllTheaters() { return theaterRepository.findAll();}

    public Page<Theater> getAllTheaters(Pageable pageRequest)
    {
        return theaterRepository.findAll(pageRequest);
    }
    public Page<Theater> getAllTheatersByCity(String city, Pageable pageRequest)
    {
        if (city == null)
            return theaterRepository.findAll(pageRequest);
        else
            return theaterRepository.findTheatersByLocationAddressCityContainsIgnoreCase(city, pageRequest);
    }

    //endregion

    //region Savers
    //These DO return the object that is saved
    //This can be either a new object if it doesn't exist, or the existing one if it's an update

    public Comment updateComment(Comment newComment)
    {
        // Save creates new entity if it doesn't exist, updates existing one if it does
        return commentRepository.save(newComment);
    }

    public Movie updateMovie(Movie newMovie)
    {
        return movieRepository.save(newMovie);
    }

    public Schedule updateSchedule(Schedule newSchedule)
    {
        return scheduleRepository.save(newSchedule);
    }

    public Theater updateTheater(Theater newTheater)
    {
        return theaterRepository.save(newTheater);
    }

    public User updateUser(User newUser)
    {
        return userRepository.save(newUser);
    }
    //endregion


    //region Deleters
    public String deleteCommentById(String id)
    {
        if (commentRepository.findCommentById(id).isEmpty()) {
            //Throw an exception here
             return "Comment Not Found";
        }
        commentRepository.deleteById(id);
        return "Comment Deleted";
    }

    public String deleteMovieById(String id)
    {
        if (movieRepository.findMovieById(id).isEmpty()) {
            //Exception
            return "Movie Not Found";
        }
        movieRepository.deleteById(id);
        return "Movie Deleted";
    }

    public String deleteScheduleById(String id)
    {
        if (scheduleRepository.findScheduleById(id).isEmpty()) {
            //Exception
            return "Schedule Not Found";
        }
        scheduleRepository.deleteById(id);
        return "Schedule Deleted";
    }

    //@Todo Discuss this with team, having to delete by the object itself
    //Theater id is a Long...? Check this
    public String deleteTheaterById(String id)
    {
        if (theaterRepository.findTheaterById(id).isEmpty()) {
            //Throw Exception
            return "Theater Not Found";
        }
        theaterRepository.deleteById(id);
        return "Theater Deleted";
    }

    //@Todo This is still up for debate
    public String deleteUserById(String id)
    {
        userRepository.deleteById(id);
        return "User Deleted";
    }
    //endregion

    //region Creators
    //Some of these are the same as the savers, as a save with new data adds it

    public Comment addComment(Comment newComment)
    {
        return commentRepository.save(newComment);
    }

    public Movie addMovie(Movie newMovie)
    {
        return movieRepository.save(newMovie);
    }

    public Schedule addSchedule(Schedule newSchedule)
    {
        return scheduleRepository.save(newSchedule);
    }

    public Theater addTheater(Theater newTheater)
    {
        return theaterRepository.save(newTheater);
    }

    public User addUser(User newUser)
    {
        return userRepository.save(newUser);
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
