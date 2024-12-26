package com.example.trelloproject.user.controller;

import com.example.trelloproject.user.dto.UserLoginRequestDto;
import com.example.trelloproject.user.dto.UserLoginResponseDto;
import com.example.trelloproject.user.dto.UserSignUpRequestDto;
import com.example.trelloproject.user.dto.UserSignUpResponseDto;
import com.example.trelloproject.user.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto, HttpServletRequest request) {
        UserLoginResponseDto userLoginResponseDto = userServiceImpl.loginUser(userLoginRequestDto);
        HttpSession session = request.getSession();
        session.setAttribute("user", userLoginResponseDto);
        return new ResponseEntity<>(userLoginResponseDto, HttpStatus.OK);
    }
}
