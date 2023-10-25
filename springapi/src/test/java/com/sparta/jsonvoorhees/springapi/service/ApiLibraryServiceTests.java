package com.sparta.jsonvoorhees.springapi.service;

import com.sparta.jsonvoorhees.springapi.model.entities.*;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.*;
import com.sparta.jsonvoorhees.springapi.model.repositories.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ApiLibraryServiceTests {
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

    //Region Test Getters
    @Test
    public void testGetAllUsers()
    {
        assertEquals(serviceLayer.getAllUsers(), new ArrayList<User>());
    }

    @Test
    public void testGetUser()
    {
        User dummyUser = new User();
        dummyUser.setName("Just a guy");
        dummyUser.setEmail("name@domain.com");
        dummyUser.setId("9999");
        Mockito.when(userRepository.findUserById("9999")).thenReturn(Optional.of(dummyUser));

        User testUserToRetrieve = serviceLayer.getUserById("9999").get();

        assertEquals(dummyUser,testUserToRetrieve);
    }
    //Endregion
}
