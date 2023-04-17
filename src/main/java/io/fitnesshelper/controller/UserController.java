package io.fitnesshelper.controller;

import io.fitnesshelper.dto.request.UserRequest;
import io.fitnesshelper.dto.response.UserResponse;
import io.fitnesshelper.entity.User;
import io.fitnesshelper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        var user = userService.createUser(from(request));

        return from(user);
    }

    private User from(UserRequest request) {
        var user = new User();

        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setProfile(request.getProfile());

        return user;
    }

    private UserResponse from(User user) {
        var response = new UserResponse();

        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setProfile(user.getProfile());

        return response;
    }

}
