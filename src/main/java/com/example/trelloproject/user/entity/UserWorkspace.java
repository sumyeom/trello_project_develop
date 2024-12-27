package com.example.trelloproject.user.entity;

import com.example.trelloproject.user.enumclass.MemberRole;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "user_workspace")
public class UserWorkspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String invitationStatus;

    @Column(nullable = false)
    private MemberRole memberRole;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    public UserWorkspace() {}

    public UserWorkspace(String invitationStatus, MemberRole memberRole) {
        this.invitationStatus = invitationStatus;
        this.memberRole = memberRole;
    }
}
