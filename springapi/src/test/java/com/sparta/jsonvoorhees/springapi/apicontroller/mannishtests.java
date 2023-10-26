package com.sparta.jsonvoorhees.springapi.apicontroller;

import com.sparta.jsonvoorhees.springapi.controller.CommentApiController;
import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import com.sparta.jsonvoorhees.springapi.model.repositories.CommentRepository;
import com.sparta.jsonvoorhees.springapi.service.IServiceLayer;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.Optional;

@WebMvcTest(CommentApiControllerTests.class)
@AutoConfigureWebMvc()
public class mannishtests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IServiceLayer serviceLayer;

    @InjectMocks
    private CommentApiController commentApiController;

//    @BeforeEach
//    public void setup(){
//        mockMvc = MockMvcBuilders.standaloneSetup(commentApiController).build();
//    }

//    @BeforeEach
//    void setup() {
//        Comment commentToReturn = new Comment();
//        commentToReturn.setId("123");
//        commentToReturn.setDate(new Date());
//        commentToReturn.setEmail("testemail@gmail.com");
//        commentToReturn.setMovieId(new ObjectId());
//        commentToReturn.setName("something");
//        commentToReturn.setText("test comment");
//        mockMvc = MockMvcBuilders.standaloneSetup()
//    }

//    @Test
//    @DisplayName("check that get comment by id returns 200 given existing id")
//    void checkThatGetCommentByIdReturns200GivenExistingId() throws Exception {
//        String commentId = "123";
//        String uritest = "http://localhost:8080/api/comments/getComment/" + commentId;
//        Comment commentToReturn = new Comment();
//        commentToReturn.setId(commentId);
//        commentToReturn.setDate(new Date());
//        commentToReturn.setEmail("testemail@gmail.com");
//        commentToReturn.setMovieId(new ObjectId());
//        commentToReturn.setName("something");
//        commentToReturn.setText("test comment");
//        Mockito.when(serviceLayer.getCommentById(commentId)).thenReturn(Optional.of(commentToReturn));
//        // Mockito.verify(serviceLayer,Mockito.times(1)).getCommentById(commentId);
//
//        mockMvc.perform(MockMvcRequestBuilders.get(uritest))
//                .andDo(MockMvcResultHandlers.print());
//
//    }
    @Test
    @DisplayName("check that get comment by id returns 200 given existing id")
    void checkThatGetCommentByIdReturns200GivenExistingId() throws Exception {
        String commentId = "123";
        String uriTest = "http://localhost:8080/api/comments/getComment/" + commentId;
        Comment commentToReturn = new Comment();
        commentToReturn.setId(commentId);
        commentToReturn.setDate(new Date());
        commentToReturn.setEmail("testemail@gmail.com");
        commentToReturn.setMovieId(new ObjectId());
        commentToReturn.setName("something");
        commentToReturn.setText("test comment");
        Mockito.when(serviceLayer.getCommentById(commentId)).thenReturn(Optional.of(commentToReturn));
        // Mockito.verify(serviceLayer,Mockito.times(1)).getCommentById(commentId);

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/comments/getComment/123"))
                .andDo(MockMvcResultHandlers.print());
    }


}
