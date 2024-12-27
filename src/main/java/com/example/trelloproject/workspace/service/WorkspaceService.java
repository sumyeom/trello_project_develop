package com.example.trelloproject.workspace.service;

import com.example.trelloproject.workspace.dto.*;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface WorkspaceService {
    WorkspaceResponseDto createWorkspace(Authentication authentication, WorkspaceRequestDto requestDto);

    List<WorkspaceFindResponseDto> getAllWorkspace();

    WorkspaceResponseDto updateWorkspace(Long id, WorkspaceRequestDto requestDto);

    void deleteWorkspace(Long id);

    WorkspaceInviteResponseDto inviteWorkspace(Authentication authentication, Long workspaceId, WorkspaceInviteRequestDto requestDto);
}
