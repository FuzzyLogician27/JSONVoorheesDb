//package com.sparta.jsonvoorhees.springapi.apicontroller;
//
//import com.sparta.jsonvoorhees.springapi.controller.CommentApiController;
//import com.sparta.jsonvoorhees.springapi.exceptions.*;
//import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
//import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import reactor.core.publisher.Mono;
//
//import java.util.Optional;
//
//@SpringBootTest
//public class CommentApiControllerTests {
//
//    @Mock
//    private ServiceLayer serviceLayer;
//    private WebTestClient testClient;
//    // @InjectMocks
//    @Autowired
//    private CommentApiController commentApiController;
//
//    @BeforeEach
//    void setup() {
//        testClient = WebTestClient.bindToController(commentApiController).build();
//    }
//
//    @Test
//    @DisplayName("check that get comment by id returns 200 given existing id")
//    void checkThatGetCommentByIdReturns200GivenExistingId() {
//        // The uri has to contain http or the test doesn't work - Most likely because IntelliJ by default uses https
////        testClient
////                .get()
////                .uri("http://localhost:8080/api/comments/getComment/5a9427648b0beebeb6957b28")
////                .exchange()
////                .expectStatus()
////                .isEqualTo(200);
//        String commentId = "validCommentId";
//        Comment commentToReturn = new Comment();
//        Mockito.when(serviceLayer.getCommentById(commentId)).thenReturn(Optional.of(commentToReturn));
//
//        testClient
//        .get()
//        .uri("http://localhost:8080/api/comments/getComment/" + commentId)
//        .exchange()
//        .expectStatus().isOk()
//        .expectBody(Comment.class)
//        .isEqualTo(commentToReturn);
//    }
//
//    @Test
//    @DisplayName("check that get comment by id returns 4xx given non existing id")
//    void checkThatGetCommentByIdReturns4xxGivenNonExistingId() {
//        // The uri has to contain http or the test doesn't work - Most likely because IntelliJ by default uses https
////        testClient
////                .get()
////                .uri("http://localhost:8080/api/comments/getComment/5a9427648b0beebeb6957b28")
////                .exchange()
////                .expectStatus()
////                .isEqualTo(200);
//
//        String invalidCommentId = "invalidCommentId";
//        var commentToReturn = new CommentNotFoundException(invalidCommentId);
//        Mockito.when(serviceLayer.getCommentById(invalidCommentId)).thenReturn(Optional.of(commentToReturn));
//
//        testClient
//                .get()
//                .uri("http://localhost:8080/api/comments/getComment/" + invalidCommentId)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(Comment.class)
//                .isEqualTo(commentToReturn);
//    }
//
//    @Test
//    @DisplayName("check that get comments by user id returns 200 for existing user id")
//    void checkThatGetCommentsByUserIdReturns200ForExistingUserId() {
//        testClient
//                .get()
//                .uri("http://localhost:8080/api/comments/getAllCommentsByUserId/59b99db5cfa9a34dcd7885b9")
//                .exchange()
//                .expectStatus()
//                .isEqualTo(200);
//    }
//
//    @Test
//    @DisplayName("check that get comments by movie id returns 200 for existing movie id")
//    void checkThatGetCommentsByMovieIdReturns200ForExistingMovieId() {
//        testClient
//                .get()
//                .uri("http://localhost:8080/api/comments/getAllCommentsByMovieId/573a1390f29313caabcd5293")
//                .exchange()
//                .expectStatus()
//                .isEqualTo(200);
//    }
//
//    @Test
//    @DisplayName("check that create comment returns 200 if given comment body which is not empty")
//    void checkThatCreateCommentReturns2xxIfGivenCommentBodyWhichIsNotEmpty() {
//        Comment comment = new Comment();
//        comment.setText("test");
//        Mockito.when(serviceLayer.addComment(comment)).thenReturn((comment));
//
//        testClient
//                .post()
//                .uri("http://localhost:8080/api/comments")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(comment)
//                .exchange()
//                .expectStatus().is2xxSuccessful()
//                .expectBody(Comment.class)
//                .isEqualTo(comment);
//    }
//
//    @Test
//    @DisplayName("check that create comment returns a commentBodyNotFoundException if passed comment is empty")
//    void checkThatCreateCommentReturnsAnExceptionIfGivenCommentBodyIsEmpty() {
//        CommentBodyNotFoundException commentBodyNotFoundException = new CommentBodyNotFoundException();
//        Mockito.when(serviceLayer.addComment(null)).thenThrow((commentBodyNotFoundException));
//
//        testClient
//                .post()
//                .uri("http://localhost:8080/api/comments")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(null)
//                .exchange()
//                .expectStatus().is4xxClientError()
//                .expectBody(CommentBodyNotFoundException.class);
//    }
//
//    @Test
//    @DisplayName("check that delete comment by id returns 200 if given existing comment id")
//    void checkThatDeleteCommentByIdReturns2xxIfGivenExistingCommentId() {
//        Mockito.when(serviceLayer.deleteCommentById("commentIdToDelete")).thenReturn(String.valueOf(Mono.just("Comment deleted successfully")));
//
//        testClient
//                .delete()
//                .uri("http://localhost:8080/api/comments/commentIdToDelete")
//                .exchange()
//                .expectStatus().is2xxSuccessful()
//                .expectBody(String.class)
//                .isEqualTo("Comment deleted successfully");
//    }
//
//    @Test
//    @DisplayName("check that delete comment by id returns an exception if given invalid id")
//    void checkThatDeleteCommentByIdReturnsAnExceptionIfGivenInvalidId() {
//        DeleteCommentNotFoundException deleteCommentNotFoundException = new DeleteCommentNotFoundException();
//        Mockito.when(serviceLayer.deleteCommentById("non existent id")).thenThrow((DeleteCommentNotFoundException));
//
//        testClient
//                .delete()
//                .uri("http://localhost:8080/api/comments/commentIdToDelete")
//                .exchange()
//                .expectStatus().is4xxClientError()
//                .expectBody(String.class)
//                .isEqualTo("Could not find comment with id: " + "non existent id");
//    }
//
//    @Test
//    @DisplayName("check that update comment returns 200 if given comment object in the body")
//    void checkThatUpdateCommentReturns2xxIfGivenCommentBodyIsNotEmpty() {
//        Comment comment = new Comment();
//        comment.setText("test");
//        Mockito.when(serviceLayer.updateComment(comment)).thenReturn((comment));
//
//        testClient
//                .patch()
//                .uri("http://localhost:8080/api/comments")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(comment)
//                .exchange()
//                .expectStatus().is2xxSuccessful()
//                .expectBody(Comment.class)
//                .isEqualTo(comment);
//    }
//
//}
