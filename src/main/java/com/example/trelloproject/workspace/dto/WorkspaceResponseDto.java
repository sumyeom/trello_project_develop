package com.example.trelloproject.workspace.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class WorkspaceResponseDto {
    private final Long id;
    private final String name;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime updateAt;

    public WorkspaceResponseDto(Long id, String name, String description, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
