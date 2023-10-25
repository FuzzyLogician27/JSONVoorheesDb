package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.exceptions.CommentNotFoundException;
import com.sparta.jsonvoorhees.springapi.exceptions.UserBodyNotFoundException;
import com.sparta.jsonvoorhees.springapi.exceptions.UserNotFoundException;
import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import com.sparta.jsonvoorhees.springapi.model.entities.Movie;
import com.sparta.jsonvoorhees.springapi.model.entities.User;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserApiController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public UserApiController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/api/users/getUsers")
    public List<User> getUsers() {
        return serviceLayer.getAllUsers();
    }

    @GetMapping("/api/users/getUser/{id}")
    public Optional<User> getUserById(@PathVariable String id) throws UserNotFoundException {
        Optional<User> userById = serviceLayer.getUserById(id);
        if (userById.isEmpty()){
            throw new UserNotFoundException(id);
        }
        return serviceLayer.getUserById(id);
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) throws UserBodyNotFoundException {
        if(user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            throw new UserBodyNotFoundException();
        }
        return serviceLayer.addUser(user);
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUser(@PathVariable String id) throws  UserNotFoundException{
        Optional<User> userById = serviceLayer.getUserById(id);
        if (userById.isEmpty()){
            throw new UserNotFoundException(id);
        }
        serviceLayer.deleteUserById(id);
    }

    @PatchMapping("/api/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable String id) throws UserNotFoundException{
        Optional<User> userById = serviceLayer.getUserById(id);
        if (userById.isEmpty()){
            throw new UserNotFoundException(id);
        }
        return serviceLayer.updateUser(user);
    }

}