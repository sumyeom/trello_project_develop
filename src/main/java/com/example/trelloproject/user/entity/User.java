package com.example.trelloproject.user.entity;

import com.example.trelloproject.user.enumclass.UserRole;
import com.example.trelloproject.user.enumclass.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "varchar(10) default 'NORMAL'")
    private UserStatus userStatus;

    @Column(nullable = false)
    private UserRole userRole;

    public User(String name, String email, String password, UserStatus userStatus,UserRole userRole) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userStatus = userStatus;
        this.userRole = userRole;
    }

    public User() {}
}
