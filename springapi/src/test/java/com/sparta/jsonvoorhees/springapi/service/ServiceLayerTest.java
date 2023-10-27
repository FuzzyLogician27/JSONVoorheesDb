package com.sparta.jsonvoorhees.springapi.service;

import com.sparta.jsonvoorhees.springapi.model.entities.*;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.*;
import com.sparta.jsonvoorhees.springapi.model.repositories.*;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.awt.*;
import java.awt.print.Pageable;
import java.util.*;
import java.util.List;

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
        dummyComment.setName("Joe Bloggs");
        dummyComment.setMovieId(new ObjectId("000000000000000000000000"));
        return dummyComment;
    }

    private static String randomString()
    {
        var randomGenerator = new Random();
        return randomGenerator.ints(97,123).limit(10).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    private static User createRandomTestUser() {

        User dummyUser = new User();
        dummyUser.setName(randomString());
        dummyUser.setEmail(randomString());
        dummyUser.setId(randomString());
        return dummyUser;
    }
    private static Theater createRandomTestTheater() {
        Theater dummyTheater = new Theater();
        dummyTheater.setTheaterId(9999);
        Address dummyAddress = new Address(randomString(),randomString(),randomString(),randomString());
        var coordinates = new ArrayList<Double>();
        coordinates.add(0,(double)0);
        Geo dummyGeo = new Geo("Point",coordinates);
        Location dummyLocation = new Location(dummyAddress,dummyGeo);
        dummyTheater.setLocation(dummyLocation);
        return dummyTheater;
    }
    private static Schedule createRandomTestSchedule() {
        Schedule dummySchedule = new Schedule();
        dummySchedule.setMovieId(randomString());
        dummySchedule.setTheaterId(randomString());
        dummySchedule.setId(randomString());
        return dummySchedule;
    }
    private static Movie createRandomTestMovie() {
        Movie dummyMovie = new Movie();
        dummyMovie.setTitle(randomString());
        dummyMovie.setPlot(randomString());
        dummyMovie.setId(randomString());
        return dummyMovie;
    }
    private static Comment createRandomTestComment() {
        Comment dummyComment = new Comment();
        dummyComment.setId(randomString());
        dummyComment.setEmail(randomString());
        dummyComment.setText(randomString());
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
    @Test
    public void testGetAllUsersByNameProvided()
    {
        ArrayList<User> objsToAdd = new ArrayList<User>();
        var targetUser = createTestUser();
        objsToAdd.add(targetUser);
        var pageRequest = PageRequest.of(0,10);

        Page<User> pageObj = new PageImpl<>(objsToAdd,pageRequest,5);
        Mockito.when(userRepository.findUsersByNameContainingIgnoreCase("Just a guy", pageRequest)).thenReturn(pageObj);

        var result = serviceLayer.getAllUsersByName("Just a guy",pageRequest);
        assertEquals(targetUser.getName(),result.getContent().get(0).getName());
    }
    @Test
    public void testGetAllUsersByNameNotProvided()
    {
        ArrayList<User> objsToAdd = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {

            objsToAdd.add(createRandomTestUser());
        }

        var pageRequest = PageRequest.of(0,10);

        Page<User> pageObj = new PageImpl<>(objsToAdd,pageRequest,10);
        Mockito.when(userRepository.findAll(pageRequest)).thenReturn(pageObj);

        var result = serviceLayer.getAllUsersByName(null,pageRequest);
        assertEquals(result.getContent().size(),5);
    }
    @Test
    public void testGetAllTheatersByCityProvided()
    {
        ArrayList<Theater> objsToAdd = new ArrayList<Theater>();
        for (int i = 0; i < 5; i++) {

            objsToAdd.add(createRandomTestTheater());
        }
        var targetUser = createTestTheater();
        objsToAdd.add(targetUser);
        var pageRequest = PageRequest.of(0,10);

        Page<Theater> pageObj = new PageImpl<>(objsToAdd,pageRequest,10);
        Mockito.when(theaterRepository.findTheatersByLocationAddressCityContainsIgnoreCase("Someplace", pageRequest)).thenReturn(pageObj);

        var result = serviceLayer.getAllTheatersByCity("Someplace",pageRequest);
        assertEquals(result.getContent().get(0).getTheaterId(),targetUser.getTheaterId());
    }
    @Test
    public void testGetAllTheatersByCityNotProvided()
    {
        ArrayList<Theater> objsToAdd = new ArrayList<Theater>();
        for (int i = 0; i < 5; i++) {

            objsToAdd.add(createRandomTestTheater());
        }

        var pageRequest = PageRequest.of(0,10);

        Page<Theater> pageObj = new PageImpl<>(objsToAdd,pageRequest,10);
        Mockito.when(theaterRepository.findAll(pageRequest)).thenReturn(pageObj);

        var result = serviceLayer.getAllTheatersByCity(null,pageRequest);
        assertEquals(result.getContent().size(),5);
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
    @Test
    public void TestDeleteCommentBad()
    {
        String response = serviceLayer.deleteCommentById("0000");
        assertEquals("Comment Not Found",response);
    }
    @Test
    public void TestDeleteMovieBad()
    {
        String response = serviceLayer.deleteMovieById("0000");
        assertEquals("Movie Not Found",response);
    }
    @Test
    public void TestDeleteScheduleBad()
    {
        String response = serviceLayer.deleteScheduleById("0000");
        assertEquals("Schedule Not Found",response);
    }
    @Test
    public void TestDeleteTheaterBad()
    {
        String response = serviceLayer.deleteTheaterById("0000");
        assertEquals("Theater Not Found",response);
    }

    //No TestDeleteUserBad as it doesn't have any error checking in

    //endregion

    //region BulkAdds
    @Test
    public void TestAddUsers()
    {
        var objsToAdd = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            objsToAdd.add(createRandomTestUser());
        }

        Mockito.when(userRepository.insert(objsToAdd)).thenReturn(objsToAdd);
        Mockito.when(userRepository.findAll()).thenReturn(objsToAdd);

        serviceLayer.addUsers(objsToAdd);

        var result = serviceLayer.getAllUsers();
        assertEquals(result,objsToAdd);
    }
    @Test
    public void TestAddTheaters()
    {
        var objsToAdd = new ArrayList<Theater>();
        for (int i = 0; i < 5; i++) {
            objsToAdd.add(createTestTheater());
        }

        Mockito.when(theaterRepository.insert(objsToAdd)).thenReturn(objsToAdd);
        Mockito.when(theaterRepository.findAll()).thenReturn(objsToAdd);

        serviceLayer.addTheaters(objsToAdd);

        var result = serviceLayer.getAllTheaters();
        assertEquals(result,objsToAdd);
    }
    @Test
    public void TestAddSchedules()
    {
        var objsToAdd = new ArrayList<Schedule>();
        for (int i = 0; i < 5; i++) {
            objsToAdd.add(createRandomTestSchedule());
        }

        Mockito.when(scheduleRepository.insert(objsToAdd)).thenReturn(objsToAdd);
        Mockito.when(scheduleRepository.findAll()).thenReturn(objsToAdd);

        serviceLayer.addSchedules(objsToAdd);

        var result = serviceLayer.getAllSchedules();
        assertEquals(result,objsToAdd);
    }
    @Test
    public void TestAddMovies()
    {
        var objsToAdd = new ArrayList<Movie>();
        for (int i = 0; i < 5; i++) {
            objsToAdd.add(createRandomTestMovie());
        }

        Mockito.when(movieRepository.insert(objsToAdd)).thenReturn(objsToAdd);
        Mockito.when(movieRepository.findAll()).thenReturn(objsToAdd);

        serviceLayer.addMovies(objsToAdd);

        var result = serviceLayer.getAllMoviesWithTitle(null);
        assertEquals(result,objsToAdd);
    }
    @Test
    public void TestAddComments()
    {
        var objsToAdd = new ArrayList<Comment>();
        for (int i = 0; i < 5; i++) {
            objsToAdd.add(createRandomTestComment());
        }

        Mockito.when(commentRepository.insert(objsToAdd)).thenReturn(objsToAdd);
        Mockito.when(commentRepository.findAll()).thenReturn(objsToAdd);

        serviceLayer.addComments(objsToAdd);

        var result = serviceLayer.getAllComments();
        assertEquals(result,objsToAdd);
    }
    //endregion

    //region BulkGets
    @Test
    public void testGetAllTheatersNonPaged()
    {
        assertEquals(serviceLayer.getAllTheaters(), new ArrayList<Theater>());
    }
    @Test
    public void testGetAllCommentsNonPaged()
    {
        assertEquals(serviceLayer.getAllComments(), new ArrayList<Comment>());
    }
    @Test
    public void testGetAllSchedulesNonPaged()
    {
        assertEquals(serviceLayer.getAllSchedules(), new ArrayList<Schedule>());
    }
    @Test
    public void testGetAllTheatersPaged()
    {
        PageRequest request = PageRequest.of(0,20);
        Page<Theater> pageObj = new PageImpl<>(new ArrayList<Theater>(),request,10);
        Mockito.when(theaterRepository.findAll(isA(PageRequest.class))).thenReturn(pageObj);
        var result = serviceLayer.getAllTheaters(request);

        assertEquals(result.getContent(), new ArrayList<Theater>());
    }
    @Test
    public void testGetAllCommentsPaged()
    {
        PageRequest request = PageRequest.of(0,20);
        Page<Comment> pageObj = new PageImpl<>(new ArrayList<Comment>(),request,10);
        Mockito.when(commentRepository.findAll(isA(PageRequest.class))).thenReturn(pageObj);
        var result = serviceLayer.getAllComments(request);

        assertEquals(result.getContent(), new ArrayList<Comment>());
    }
    @Test
    public void testGetAllSchedulesPaged()
    {
        PageRequest request = PageRequest.of(0,20);
        Page<Schedule> pageObj = new PageImpl<>(new ArrayList<Schedule>(),request,10);
        Mockito.when(scheduleRepository.findAll(isA(PageRequest.class))).thenReturn(pageObj);
        var result = serviceLayer.getAllSchedules(request);

        assertEquals(result.getContent(), new ArrayList<Schedule>());
    }
    @Test
    public void testGetAllUsersPaged()
    {
        PageRequest request = PageRequest.of(0,20);
        Page<User> pageObj = new PageImpl<>(new ArrayList<User>(),request,10);
        Mockito.when(userRepository.findAll(isA(PageRequest.class))).thenReturn(pageObj);
        var result = serviceLayer.getAllUsers(request);

        assertEquals(result.getContent(), new ArrayList<User>());
    }
    //endregion

    //region ExtraComments
    //getCommentsWithSpecifiedWords
    @Test
    public void testGetCommentsByUser()
    {
        var comments = new ArrayList<Comment>();

        comments.add(createTestComment()); //Joe Bloggs

        Mockito.when(commentRepository.findCommentsByNameContains("Joe Bloggs")).thenReturn(comments);
        var result = serviceLayer.getCommentsByUser("Joe Bloggs");

        assertEquals(result,comments);
    }
    @Test
    public void testGetCommentsByMovie()
    {
        var comments = new ArrayList<Comment>();

        comments.add(createTestComment()); //0000

        Mockito.when(commentRepository.findCommentsByMovieId(isA(String.class))).thenReturn(comments);
        var result = serviceLayer.getCommentsByMovie("0000");

        assertEquals(result,comments);
    }

    //endregion

    //region TheaterExtras
    @Test
    public void getTheaterByTheaterId()
    {
        Theater testTheater = createTestTheater(); //9999
        Mockito.when(theaterRepository.findTheaterByTheaterId(9999L)).thenReturn(Optional.of(testTheater));

        var result = serviceLayer.getTheaterByTheaterId(9999l).get();
        assertEquals(result,testTheater);
    }
    @Test
    public void getSchedulesForTheaters()
    {
        ArrayList<Schedule> schedules = new ArrayList<Schedule>();

        for (int i = 0; i < 5; i++) {
            Schedule dummySchedule = new Schedule();
            dummySchedule.setMovieId(String.valueOf(i));
            dummySchedule.setTheaterId("0000");
            dummySchedule.setId("0000");
            schedules.add(dummySchedule);
        }
        Mockito.when(scheduleRepository.findSchedulesByTheaterId(isA(String.class))).thenReturn(schedules);

        var result = serviceLayer.getSchedulesForTheaters("0000");

        assertEquals(result,schedules);
    }
    //endregion

    //region MovieSpecialGetters
    @Test
    public void getAllMoviesWithTitleNotProvided()
    {
        var objsToAdd = new ArrayList<Movie>();
        for (int i = 0; i < 5; i++) {
            objsToAdd.add(createRandomTestMovie());
        }

        Mockito.when(movieRepository.findAll()).thenReturn(objsToAdd);

        var result = serviceLayer.getAllMoviesWithTitle(null);
        assertEquals(result,objsToAdd);
    }
    @Test
    public void getAllMoviesWithTitleProvided()
    {
        var objsToAdd = new ArrayList<Movie>();
        for (int i = 0; i < 5; i++) {
            objsToAdd.add(createRandomTestMovie());
        }
        Movie actualMovie = createTestMovie();//"A grand adventure in mongo"
        objsToAdd.add(actualMovie);

        Mockito.when(movieRepository.findAll()).thenReturn(objsToAdd);

        var result = serviceLayer.getAllMoviesWithTitle("A grand adventure in mongo");
        assertEquals(actualMovie,result.get(0));
    }
    @Test
    public void getAllMoviesWithTitleProvidedPageable()
    {
        var objsToAdd = new ArrayList<Movie>();
        Movie actualMovie = createTestMovie();//"A grand adventure in mongo"
        objsToAdd.add(actualMovie);

        PageRequest request = PageRequest.of(0,20);
        Page<Movie> pageObj = new PageImpl<>(objsToAdd,request,10);
        Mockito.when(movieRepository.findMoviesByTitleContainsIgnoreCase
                ("A grand adventure in mongo",request)).thenReturn(pageObj);
        var result = serviceLayer.getAllMoviesWithTitle("A grand adventure in mongo",request);

        assertEquals(actualMovie.getTitle(),result.getContent().get(0).getTitle());
    }
    @Test
    public void getAllMoviesWithTitleNotProvidedPagable()
    {
        ArrayList<Movie> objsToAdd = new ArrayList<Movie>();
        for (int i = 0; i < 5; i++) {

            objsToAdd.add(createRandomTestMovie());
        }
        var pageRequest = PageRequest.of(0,10);

        Page<Movie> pageObj = new PageImpl<>(objsToAdd,pageRequest,5);
        Mockito.when(movieRepository.findAll(isA(PageRequest.class))).thenReturn(pageObj);

        var result = serviceLayer.getAllMoviesWithTitle(null,pageRequest);
        assertEquals(result.getContent(),objsToAdd);
    }
    //endregion
}
