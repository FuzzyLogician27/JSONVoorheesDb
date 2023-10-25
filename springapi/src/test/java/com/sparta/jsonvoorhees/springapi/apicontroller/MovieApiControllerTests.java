package com.sparta.jsonvoorhees.springapi.apicontroller;

import com.sparta.jsonvoorhees.springapi.controller.MovieApiController;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public class MovieApiControllerTests {

    @Mock
    private ServiceLayer serviceLayer;
    private WebTestClient testClient;
    @Autowired
    private MovieApiController movieApiController;

    @BeforeEach
    void setup() {
        testClient = WebTestClient.bindToController(movieApiController).build();
    }


}
