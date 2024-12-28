package com.example.trelloproject.user.service;

import com.example.trelloproject.user.dto.JwtAuthReponseDto;
import com.example.trelloproject.user.dto.UserLoginRequestDto;
import com.example.trelloproject.user.dto.UserSignUpRequestDto;
import com.example.trelloproject.user.dto.UserSignUpResponseDto;
import org.springframework.dao.DuplicateKeyException;

public interface UserService {

    UserSignUpResponseDto createUser(UserSignUpRequestDto userSignUpRequestDto) throws DuplicateKeyException;

    JwtAuthReponseDto loginUser(UserLoginRequestDto userLoginRequestDto);
}
