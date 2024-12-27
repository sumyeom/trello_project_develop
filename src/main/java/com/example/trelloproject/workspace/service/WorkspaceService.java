package com.example.trelloproject.workspace.service;

import com.example.trelloproject.workspace.dto.WorkspaceRequestDto;
import com.example.trelloproject.workspace.dto.WorkspaceFindResponseDto;
import com.example.trelloproject.workspace.dto.WorkspaceResponseDto;

import java.util.List;

public interface WorkspaceService {
    WorkspaceResponseDto createWorkspace(WorkspaceRequestDto requestDto);

    List<WorkspaceFindResponseDto> getAllWorkspace();

    WorkspaceResponseDto updateWorkspace(Long id, WorkspaceRequestDto requestDto);

    void deleteWorkspace(Long id);
}
