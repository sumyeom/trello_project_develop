package com.example.trelloproject.workspace.service;

import com.example.trelloproject.workspace.dto.WorkspaceCreateRequestDto;
import com.example.trelloproject.workspace.dto.WorkspaceFindResponseDto;
import com.example.trelloproject.workspace.dto.WorkspaceResponseDto;

import java.util.List;

public interface WorkspaceService {
    WorkspaceResponseDto createWorkspace(WorkspaceCreateRequestDto requestDto);

    List<WorkspaceFindResponseDto> getAllWorkspace();
}
