package com.example.trelloproject.user.exception;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e) {

        Map<String, String> response = new HashMap<>();
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        response.put("message", message);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<Map<String, String>> handleAuthException(AuthenticationException e) {

        HttpStatus statusCode = e instanceof BadCredentialsException
                ? HttpStatus.FORBIDDEN
                : HttpStatus.UNAUTHORIZED;

        Map<String, String> response = new HashMap<>();
        response.put("message", "access denied");

        return ResponseEntity.status(statusCode).body(response);
    }

    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<Map<String, String>> handleAccessDeniedException(AccessDeniedException e) {

        Map<String, String> response = new HashMap<>();
        response.put("message", "access denied");

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    protected ResponseEntity<Map<String, String>> handleAuthorizationDeniedException(AuthorizationDeniedException e) {

        Map<String, String> response = new HashMap<>();
        response.put("message", "access denied");

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(JwtException.class)
    protected ResponseEntity<Map<String, String>> handleJwtException(JwtException e) {
        HttpStatus httpStatus = e instanceof ExpiredJwtException
                ? HttpStatus.UNAUTHORIZED
                : HttpStatus.FORBIDDEN;

        Map<String, String> response = new HashMap<>();
        response.put("message", "access denied");

        return ResponseEntity.status(httpStatus).body(response);
    }
}
