package io.fitnesshelper.controller;

import io.fitnesshelper.dto.request.LoginRequest;
import io.fitnesshelper.dto.response.LoginResponse;
import io.fitnesshelper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/login")
public class LoginController {

    private final UserService userService;

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest request) {
        var user = userService.findByEmail(request.getEmail());

        if (!user.getPassword().equals(request.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password");
        }

        var token = new Jwt().toString();

        return new LoginResponse(token, user);
    }
}
