package com.sparta.jsonvoorhees.springapi.controller;

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
    public Optional<User> getUserById(@PathVariable String id) {
        return serviceLayer.getUserById(id);
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return serviceLayer.addUser(user);
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUser(@PathVariable String id) {
        serviceLayer.deleteUserById(id);
    }

    @PatchMapping("/api/users")
    public User updateUser(@RequestBody User user) {
        return serviceLayer.updateUser(user);
    }

}