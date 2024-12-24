package com.example.trelloproject.workspace.dto;

import lombok.Getter;

@Getter
public class WorkspaceCreateRequestDto {
    private final String name;
    private final String description;

    public WorkspaceCreateRequestDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
