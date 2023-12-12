package com.project.Kutyakozmetika.controller;

import com.project.Kutyakozmetika.dto.userDto.SignupRequest;
import com.project.Kutyakozmetika.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SignupController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
        return new ResponseEntity<>(authService.createUser(signupRequest), HttpStatus.CREATED);
    }
}
