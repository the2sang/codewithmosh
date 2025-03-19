package com.example.codewithmosh.controller;

import com.example.codewithmosh.controller.request.UserRequest;
import com.example.codewithmosh.controller.response.UserResponse;
import com.example.codewithmosh.dtos.UserDto;
import com.example.codewithmosh.entities.Address;
import com.example.codewithmosh.entities.User;
import com.example.codewithmosh.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponse> createUserDefault(@RequestBody UserDto userDto) {
        List savedAddresses = new ArrayList<Address>();

        User savedUser = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .addresses(savedAddresses)
                .build();

        userDto.getAddresses().forEach(address -> {

            savedUser.addAddress(
                    Address.builder()
                            .street(address.getStreet())
                            .city(address.getCity())
                            .zip(address.getZip())
                            .state(address.getState())
                            .build()
            );

        });

        User returnUser = userService.saveUser(savedUser);

        UserResponse userResponse = new UserResponse(returnUser.getName(), returnUser.getEmail());

       return ResponseEntity.ok(userResponse);
    }

}
