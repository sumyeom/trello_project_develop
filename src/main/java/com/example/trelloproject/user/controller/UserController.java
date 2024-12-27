package com.example.trelloproject.user.controller;

import com.example.trelloproject.user.dto.*;
import com.example.trelloproject.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<UserSignUpResponseDto> createUser(@RequestBody UserSignUpRequestDto userSignUpRequestDto) {
        return new ResponseEntity<>(userServiceImpl.createUser(userSignUpRequestDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthReponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        JwtAuthReponseDto userLoginResponseDto = userServiceImpl.loginUser(userLoginRequestDto);
        return new ResponseEntity<>(userLoginResponseDto, HttpStatus.OK);
    }

    @GetMapping("/auth-test")
    public String authTest(Authentication authentication) {
        return authentication.getPrincipal().toString();
    }
}
