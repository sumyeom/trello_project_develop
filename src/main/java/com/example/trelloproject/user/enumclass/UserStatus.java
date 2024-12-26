package com.example.trelloproject.user.enumclass;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Getter
public enum UserStatus {
    NORMAL("NORMAL"), DELETED("DELETED");

    private String name;

    UserStatus(String name) {
        this.name = name;
    }

    public static UserStatus of(String name) throws IllegalArgumentException {
        for (UserStatus status : values()) {
            if (status.getName().equals(name)) {
                return status;
            }
        }

        throw new IllegalArgumentException("해당 상태가 존재하지 않습니다." + name);
    }

    public List<SimpleGrantedAuthority> getAuthority() {
        return List.of(new SimpleGrantedAuthority(name));
    }
}
