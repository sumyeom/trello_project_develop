package com.example.trelloproject.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class JwtAuthReponseDto {

    private String tokenAuthScheme;
    private String accessToken;

    public JwtAuthReponseDto(String tokenAuthScheme, String accessToken) {
        this.tokenAuthScheme = tokenAuthScheme;
        this.accessToken = accessToken;
    }
}
