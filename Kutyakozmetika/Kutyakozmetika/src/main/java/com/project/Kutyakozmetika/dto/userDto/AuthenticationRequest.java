package com.project.Kutyakozmetika.dto.userDto;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String username;
    private String password;
}
