package com.sparta.jsonvoorhees.springapi.service;

import com.sparta.jsonvoorhees.springapi.model.entities.*;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.*;
import com.sparta.jsonvoorhees.springapi.model.repositories.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@SpringBootTest
public class ServiceLayerTest {
    @Mock
    private static MovieRepository movieRepository;
    @Mock
    private static UserRepository userRepository;
    @Mock
    private static CommentRepository commentRepository;
    @Mock
    private static TheaterRepository theaterRepository;
    @Mock
    private static ScheduleRepository scheduleRepository;
    @InjectMocks
    private ServiceLayer serviceLayer;

    @BeforeEach
    void setUp()
    {
        serviceLayer = new ServiceLayer(commentRepository,
                movieRepository,scheduleRepository,theaterRepository,
                userRepository);

    }

    //region Test Data Creation
    private static User createTestUser() {
        User dummyUser = new User();
        dummyUser.setName("Just a guy");
        dummyUser.setEmail("name@domain.com");
        dummyUser.setId("9999");
        return dummyUser;
    }
    private static Theater createTestTheater() {
        Theater dummyTheater = new Theater();
        dummyTheater.setTheaterId(9999);
        Address dummyAddress = new Address("Somewhere","Someplace","Nowhere","Maybe");
        var coordinates = new ArrayList<Double>();
        coordinates.add(0,(double)0);
        Geo dummyGeo = new Geo("Point",coordinates);
        Location dummyLocation = new Location(dummyAddress,dummyGeo);
        dummyTheater.setLocation(dummyLocation);
        return dummyTheater;
    }
    private static Schedule createTestSchedule() {
        Schedule dummySchedule = new Schedule();
        dummySchedule.setMovieId("1010");
        dummySchedule.setTheaterId("0101");
        dummySchedule.setId("0000");
        return dummySchedule;
    }
    private static Movie createTestMovie() {
        Movie dummyMovie = new Movie();
        dummyMovie.setTitle("A grand adventure in mongo");
        dummyMovie.setPlot("A thrilling tail of the loss of hope");
        dummyMovie.setId("0000");
        return dummyMovie;
    }
    private static Comment createTestComment() {
        Comment dummyComment = new Comment();
        dummyComment.setId("0000");
        dummyComment.setEmail("name@domain.com");
        dummyComment.setText("(╯°□°）╯︵ ┻━┻");
        return dummyComment;
    }
    //endregion

    //region Test Create
    @Test
    public void testCreateComment()
    {
        Comment dummyComment = createTestComment();

        Mockito.when(commentRepository.save(dummyComment)).thenReturn(dummyComment);

        Comment testCommentToAdd = serviceLayer.addComment(dummyComment);

        assertEquals(dummyComment, testCommentToAdd);
    }

    @Test
    public void testCreateMovie()
    {
        Movie dummyMovie = createTestMovie();

        Mockito.when(movieRepository.save(dummyMovie)).thenReturn(dummyMovie);

        Movie testMovieToAdd = serviceLayer.addMovie(dummyMovie);

        assertEquals(dummyMovie,testMovieToAdd);
    }
    @Test
    public void testCreateSchedule()
    {
        Schedule dummySchedule = createTestSchedule();

        Mockito.when(scheduleRepository.save(dummySchedule)).thenReturn(dummySchedule);

        Schedule testObjToAdd = serviceLayer.addSchedule(dummySchedule);

        assertEquals(dummySchedule,testObjToAdd);
    }
    @Test
    public void testCreateTheater()
    {
        Theater dummyTheater = createTestTheater();

        Mockito.when(theaterRepository.save(dummyTheater)).thenReturn(dummyTheater);

        Theater testObjToAdd = serviceLayer.addTheater(dummyTheater);

        assertEquals(dummyTheater,testObjToAdd);
    }
    @Test
    public void testCreateUser()
    {
        User dummyObj = createTestUser();

        Mockito.when(userRepository.save(dummyObj)).thenReturn(dummyObj);

        User testObjToAdd = serviceLayer.addUser(dummyObj);

        assertEquals(dummyObj,testObjToAdd);
    }
    //endregion

    //region Test Read
    @Test
    public void testGetAllUsers()
    {
        assertEquals(serviceLayer.getAllUsers(), new ArrayList<User>());
    }
    @Test
    public void testGetUser()
    {
        User dummyUser = createTestUser();
        Mockito.when(userRepository.findUserById("9999")).thenReturn(Optional.of(dummyUser));

        User testUserToRetrieve = serviceLayer.getUserById("9999").get();

        assertEquals(dummyUser,testUserToRetrieve);
    }
    @Test
    public void testGetTheater()
    {
        Theater dummyTheater = createTestTheater();

        Mockito.when(theaterRepository.findTheaterById("9999")).thenReturn(Optional.of(dummyTheater));

        Theater testTheaterToRetrieve = serviceLayer.getTheaterById("9999").get();

        assertEquals(dummyTheater,testTheaterToRetrieve);
    }
    @Test
    public void testGetSchedules()
    {
        Schedule dummySchedule = createTestSchedule();

        Mockito.when(scheduleRepository.findScheduleById("0000")).thenReturn(Optional.of(dummySchedule));

        Schedule testScheduleToRetrieve = serviceLayer.getScheduleById("0000").get();

        assertEquals(dummySchedule,testScheduleToRetrieve);
    }
    @Test
    public void testGetMovie()
    {
        Movie dummyMovie = createTestMovie();

        Mockito.when(movieRepository.findMovieById("0000")).thenReturn(Optional.of(dummyMovie));

        Movie testMovieToRetrieve = serviceLayer.getMovieById("0000").get();

        assertEquals(dummyMovie,testMovieToRetrieve);
    }

    @Test
    public void testGetComment()
    {
        Comment dummyComment = createTestComment();

        Mockito.when(commentRepository.findCommentById("0000")).thenReturn(Optional.of(dummyComment));

        Comment testCommentToRetrieve = serviceLayer.getCommentById("0000").get();

        assertEquals(dummyComment, testCommentToRetrieve);
    }
    //endregion

    //region Test Update
    @Test
    public void testUpdateUser()
    {
        User testUser = createTestUser();

        Mockito.when(userRepository.save(isA(User.class)))
                .thenReturn(testUser);

        User response = serviceLayer.updateUser(testUser);

        assertEquals(testUser,response);
    }


    @Test
    public void testUpdateComment()
    {
        Comment testComment = createTestComment();

        Mockito.when(commentRepository.save(isA(Comment.class)))
                .thenReturn(testComment);

        Comment response = serviceLayer.updateComment(testComment);

        assertEquals(testComment,response);
    }

    @Test
    public void testUpdateFilm()
    {
        Movie testFilm = createTestMovie();

        Mockito.when(movieRepository.save(isA(Movie.class)))
                .thenReturn(testFilm);

        Movie response = serviceLayer.updateMovie(testFilm);

        assertEquals(testFilm,response);
    }

    @Test
    public void testUpdateTheater()
    {
        Theater testTheater = createTestTheater();

        Mockito.when(theaterRepository.save(isA(Theater.class)))
                .thenReturn(testTheater);

        Theater response = serviceLayer.updateTheater(testTheater);

        assertEquals(testTheater,response);
    }

    @Test
    public void testUpdateSchedule()
    {
        Schedule testSchedule = createTestSchedule();

        Mockito.when(scheduleRepository.save(isA(Schedule.class)))
                .thenReturn(testSchedule);

        Schedule response = serviceLayer.updateSchedule(testSchedule);

        assertEquals(testSchedule,response);
    }

    //endregion

    //region Test Delete
    @Test
    public void TestDeleteComment()
    {
        Mockito.when(commentRepository.findCommentById("0000")).thenReturn(Optional.of(new Comment()));
        Mockito.doNothing().when(commentRepository).deleteById(isA(String.class));

        String response = serviceLayer.deleteCommentById("0000");

        assertEquals("Comment Deleted",response);
    }

    @Test
    public void TestDeleteMovie()
    {
        Mockito.when(movieRepository.findMovieById("0000")).thenReturn(Optional.of(new Movie()));
        Mockito.doNothing().when(movieRepository).deleteById(isA(String.class));

        String response = serviceLayer.deleteMovieById("0000");

        assertEquals("Movie Deleted",response);
    }

    @Test
    public void TestDeleteSchedule()
    {
        Mockito.when(scheduleRepository.findScheduleById("0000")).thenReturn(Optional.of(new Schedule()));
        Mockito.doNothing().when(scheduleRepository).deleteById(isA(String.class));

        String response = serviceLayer.deleteScheduleById("0000");

        assertEquals("Schedule Deleted",response);
    }

    @Test
    public void TestDeleteTheater()
    {
        Mockito.when(theaterRepository.findTheaterById("0000")).thenReturn(Optional.of(new Theater()));
        Mockito.doNothing().when(theaterRepository).deleteById(isA(String.class));

        String response = serviceLayer.deleteTheaterById("0000");

        assertEquals("Theater Deleted",response);
    }

    @Test
    public void TestDeleteUser()
    {
        Mockito.when(userRepository.findUserById("0000")).thenReturn(Optional.empty());
        Mockito.doNothing().when(userRepository).deleteById(isA(String.class));

        serviceLayer.deleteUserById("0000");

        var result = serviceLayer.getUserById("0000");
        assertFalse(result.isPresent());
    }
    //endregion
}
