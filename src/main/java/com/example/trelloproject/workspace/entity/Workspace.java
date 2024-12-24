package com.example.trelloproject.workspace.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name= "wordkspace")
public class Workspace {
    @Id
    @Column(name = "workspace_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workspaceId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    public Workspace(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Workspace() {

    }
}
