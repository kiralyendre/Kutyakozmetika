package com.project.Kutyakozmetika.dto.userDto;

import lombok.Data;

@Data
public class SignupRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String username;
}
