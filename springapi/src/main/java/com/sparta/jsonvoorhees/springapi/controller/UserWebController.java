package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.exceptions.UserBodyNotFoundException;
import com.sparta.jsonvoorhees.springapi.exceptions.UserNotFoundException;
import com.sparta.jsonvoorhees.springapi.model.entities.User;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserWebController {

    private final ServiceLayer serviceLayer;

    public UserWebController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/web/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getUserById(Model model, @PathVariable String id) throws UserNotFoundException {
        Optional<User> userById = serviceLayer.getUserById(id);
        if (userById.isEmpty()){
            throw new UserNotFoundException(id);
        }
        User user = userById.get();
        model.addAttribute("user",user);
        return "users/user";
    }

    @GetMapping("/web/users")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAllUsers(Model model,
                               @RequestParam(name="name", required = false) String name,
                               @RequestParam(name="page", required = false) Optional<Integer> page,
                               @RequestParam(name="pageSize", required = false) Optional<Integer> pageSize) {

        model.addAttribute("users", serviceLayer.getAllUsersByName(name,
                PageRequest.of(
                        page.orElse(1)-1,
                        pageSize.orElse(50))));
        return "/users/users";
    }

    @GetMapping("/web/user/create")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getCreateForm(Model model) {
        model.addAttribute("userToCreate",new User());
        return "users/user-create-form";
    }

    @PostMapping("/web/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createUser(@ModelAttribute("userToCreate") User user) throws UserBodyNotFoundException {
        if (user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()){
            throw new UserBodyNotFoundException();
        }
        serviceLayer.addUser(user);
        return "create-success";
    }

    @GetMapping("/web/user/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getDeleteForm(Model model, @PathVariable String id) throws UserNotFoundException{
        Optional<User> userById = serviceLayer.getUserById(id);
        if (userById.isEmpty()){
            throw new UserNotFoundException(id);
        }
        model.addAttribute("userToDelete", serviceLayer.getUserById(id).orElse(null));
        return "users/user-delete-form";
    }

    @PostMapping("/web/deleteUser")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@ModelAttribute("userToDelete") User user) {
        serviceLayer.deleteUserById(user.getId());
        return "delete-success";
    }
}
