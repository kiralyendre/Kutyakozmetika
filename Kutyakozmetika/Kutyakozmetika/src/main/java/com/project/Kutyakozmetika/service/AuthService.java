package com.project.Kutyakozmetika.service;

import com.project.Kutyakozmetika.domain.User;
import com.project.Kutyakozmetika.dto.userDto.SignupRequest;
import com.project.Kutyakozmetika.dto.userDto.UserDto;
import com.project.Kutyakozmetika.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
public User createUser(SignupRequest signupRequest) {
    User user = new User();
    user.setEmail(signupRequest.getEmail());
    user.setFirstName(signupRequest.getFirstName());
    user.setLastName(signupRequest.getLastName());
    user.setPhone(signupRequest.getPhone());
    user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));

    return userRepository.save(user);
//userDto NEM KELL
    //Role még nincs átadva de azt itt kelleni fog
}
}
