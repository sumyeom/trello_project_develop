package com.example.trelloproject.user.entity;

import com.example.trelloproject.user.enumclass.MemberRole;
import com.example.trelloproject.workspace.entity.Workspace;
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

    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private Workspace workspace;

    public UserWorkspace() {}

    public UserWorkspace(User user, Workspace workspace, String invitationStatus, MemberRole memberRole) {
        this.users = user;
        this.workspace = workspace;
        this.invitationStatus = invitationStatus;
        this.memberRole = memberRole;
    }
}
