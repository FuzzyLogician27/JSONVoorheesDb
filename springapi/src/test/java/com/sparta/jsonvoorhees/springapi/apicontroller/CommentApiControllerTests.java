package com.sparta.jsonvoorhees.springapi.apicontroller;

import com.sparta.jsonvoorhees.springapi.controller.CommentApiController;
import com.sparta.jsonvoorhees.springapi.exceptions.*;
import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import com.sparta.jsonvoorhees.springapi.service.IServiceLayer;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@SpringBootTest
public class CommentApiControllerTests {

//    @Autowired
//    private MockMvc mockMvc;

//    @MockBean
//    private IServiceLayer serviceLayer;
    private WebTestClient testClient;
    @Autowired
    private CommentApiController commentApiController;

    @BeforeEach
    void setup() {
        testClient = WebTestClient.bindToController(commentApiController).build();
    }

    @Test
    @DisplayName("check that get comment by id returns 200 given existing id")
    void checkThatGetCommentByIdReturns200GivenExistingId() {
        String commentId = "5a9427648b0beebeb6957b28";
        String uritest = "http://localhost:8080/api/comments/getComment/" + commentId;

     //  The uri has to contain http or the test doesn't work - Most likely because IntelliJ by default uses https
        testClient
                .get()
                .uri(uritest)
                .exchange()
                .expectStatus()
                .isEqualTo(200);
  }



}
