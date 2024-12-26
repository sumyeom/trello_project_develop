package com.example.trelloproject.user.dto;

import lombok.Getter;

@Getter
public class UserLoginResponseDto {
    private String name;
    private String email;

    public UserLoginResponseDto(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
