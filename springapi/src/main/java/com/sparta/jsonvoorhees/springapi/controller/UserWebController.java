package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.model.entities.User;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
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
    public String getUserById(Model model, @PathVariable String id) {
        User user = serviceLayer.getUserById(id).get();
        model.addAttribute("user",user);
        //model.addAttribute("comments",serviceLayer.getCommentsByEmail(user.email)); - implement later
        return "users/user";
    }

    @GetMapping("/web/users")
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

    //@GetMapping("/web/users")
    //public String getAllUsers(Model model) {
    //    model.addAttribute("users", serviceLayer.getAllUsers());
    //    return "users/users";
    //}

    @GetMapping("/web/user/create")
    public String getCreateForm(Model model) {
        model.addAttribute("userToCreate",new User());
        return "users/user-create-form";
    }

    @PostMapping("/web/createUser")
    public String createUser(@ModelAttribute("userToCreate") User user) {
        serviceLayer.addUser(user);
        return "create-success";
    }

    @GetMapping("/web/user/delete/{id}")
    public String getDeleteForm(Model model, @PathVariable String id) {
        model.addAttribute("userToDelete", serviceLayer.getUserById(id).orElse(null));
        return "users/user-delete-form";
    }

    @PostMapping("/web/deleteUser")
    public String deleteUser(@ModelAttribute("userToDelete") User user) {
        serviceLayer.deleteUserById(user.getId());
        return "delete-success";
    }
}
