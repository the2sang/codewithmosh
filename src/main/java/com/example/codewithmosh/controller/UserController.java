package com.example.codewithmosh.controller;

import com.example.codewithmosh.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "createUser")
    public String createUser() {
        userService.persistRelated();
        return "User created";
    }
}
