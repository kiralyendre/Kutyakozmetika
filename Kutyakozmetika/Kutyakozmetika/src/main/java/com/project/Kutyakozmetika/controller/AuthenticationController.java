package com.project.Kutyakozmetika.controller;

import com.project.Kutyakozmetika.dto.userDto.AuthenticationRequest;
import com.project.Kutyakozmetika.dto.userDto.AuthenticationResponse;
import com.project.Kutyakozmetika.repository.UserRepository;
import com.project.Kutyakozmetika.service.jwt.UserDetailsServiceImpl;
import com.project.Kutyakozmetika.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;


@PostMapping("/authenticate")
public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response)
        throws BadCredentialsException,
        DisabledException,
        UsernameNotFoundException,
        IOException {
    String identifier = authenticationRequest.getEmail() != null ? authenticationRequest.getEmail() : authenticationRequest.getUsername();

    try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(identifier, authenticationRequest.getPassword()));
    } catch (BadCredentialsException e) {
        throw new BadCredentialsException("Incorrect username or password!");
    } catch (DisabledException disabledException) {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not created. Register User first.");
        return null;
    }

    final UserDetails userDetails = userDetailsService.loadUserByUsername(identifier);
    final String jwt = jwtUtil.generateToken(userDetails.getUsername());
    return new AuthenticationResponse(jwt);
}
}
