package com.project.Kutyakozmetika.controller;

import com.project.Kutyakozmetika.dto.userDto.SignupRequest;
import com.project.Kutyakozmetika.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SignupController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
        log.info("New User created: " + signupRequest.getUsername());
        return new ResponseEntity<>(authService.createUser(signupRequest), HttpStatus.CREATED);
    }
}
