package com.example.trelloproject.user.config;

import com.example.trelloproject.user.interceptor.AnyAuthInterceptor;
import com.example.trelloproject.user.interceptor.WorkspaceAuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private static final String[] WORKSPACE_ROLE_REQUIRED_PATH_PATTERNS = {"/workspaces/**"};
    private static final String[] BOARD_ROLE_REQUIRED_PATH_PATTERNS = {""};
    private static final String[] LIST_ROLE_REQUIRED_PATH_PATTERNS = {""};
    private static final String[] CARD_ROLE_REQUIRED_PATH_PATTERNS = {""};
    private static final String[] COMMENT_ROLE_REQUIRED_PATH_PATTERNS = {""};

    private final WorkspaceAuthInterceptor workspaceAuthInterceptor;
    private final AnyAuthInterceptor anyAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(workspaceAuthInterceptor)
                .addPathPatterns(WORKSPACE_ROLE_REQUIRED_PATH_PATTERNS)
                .order(Ordered.HIGHEST_PRECEDENCE);

        registry.addInterceptor(anyAuthInterceptor)
                .addPathPatterns(BOARD_ROLE_REQUIRED_PATH_PATTERNS)
                .order(Ordered.HIGHEST_PRECEDENCE + 2);

        registry.addInterceptor(anyAuthInterceptor)
                .addPathPatterns(LIST_ROLE_REQUIRED_PATH_PATTERNS)
                .order(Ordered.HIGHEST_PRECEDENCE + 2);

        registry.addInterceptor(anyAuthInterceptor)
                .addPathPatterns(CARD_ROLE_REQUIRED_PATH_PATTERNS)
                .order(Ordered.HIGHEST_PRECEDENCE + 2);

        registry.addInterceptor(anyAuthInterceptor)
                .addPathPatterns(COMMENT_ROLE_REQUIRED_PATH_PATTERNS)
                .order(Ordered.HIGHEST_PRECEDENCE + 2);
    }
}
