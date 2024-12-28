package com.example.trelloproject.workspace.entity;

import com.example.trelloproject.common.entity.CreateAndUpdateDateEntity;
import com.example.trelloproject.user.entity.UserWorkspace;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name= "workspace")
public class Workspace extends CreateAndUpdateDateEntity {
    @Id
    @Column(name = "workspace_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workspaceId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "workspace")
    private List<UserWorkspace> userWorkspace = new ArrayList<>();

    public Workspace(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Workspace() {

    }

    public void updateWorkspace(String name, String description){
        this.name = name;
        this.description = description;
    }
}
