package com.example.trelloproject.user.entity;

import com.example.trelloproject.user.enumclass.UserRole;
import com.example.trelloproject.user.enumclass.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity(name = "user")
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

    @Column(nullable = false)
    private UserStatus userStatus;

    @Column(nullable = false)
    private UserRole userRole;

    @ManyToOne
    @JoinColumn(name = "user_workspace_id")
    private UserWorkspace userWorkspace;

    public User() {}

    public User(String name, String email, String password, UserRole userRole) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.userStatus = UserStatus.NORMAL;
    }
}

