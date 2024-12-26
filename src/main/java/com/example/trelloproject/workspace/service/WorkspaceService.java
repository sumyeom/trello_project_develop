package com.example.trelloproject.workspace.service;

import com.example.trelloproject.workspace.dto.WorkspaceCreateRequestDto;
import com.example.trelloproject.workspace.dto.WorkspaceResponseDto;

public interface WorkspaceService {
    WorkspaceResponseDto createWorkspace(WorkspaceCreateRequestDto requestDto);
}
