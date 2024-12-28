package com.example.trelloproject.user.config.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
public class DelegatedAccessDeniedHandler implements AccessDeniedHandler {

    private final HandlerExceptionResolver resolver;

    public DelegatedAccessDeniedHandler(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        resolver.resolveException(request, response, null, accessDeniedException);

        // 상태 코드가 설정되지 않았다면 명시적으로 설정
        if (!response.isCommitted()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403 Forbidden
            response.getWriter().write("{\"message\": \"Access Denied\"}");
            response.getWriter().flush();
        }
    }
}
