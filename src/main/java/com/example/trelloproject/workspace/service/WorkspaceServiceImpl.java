package com.example.trelloproject.workspace.service;

import com.example.trelloproject.workspace.dto.WorkspaceCreateRequestDto;
import com.example.trelloproject.workspace.dto.WorkspaceResponseDto;
import com.example.trelloproject.workspace.entity.Workspace;
import com.example.trelloproject.workspace.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    @Override
    public WorkspaceResponseDto createWorkspace(WorkspaceCreateRequestDto requestDto) {
        //TODO: 유저 멤버 역할 확인 필요
        Workspace workspace = new Workspace(requestDto.getName(), requestDto.getDescription());
        Workspace newWorkspace = workspaceRepository.save(workspace);

        return new WorkspaceResponseDto(
                newWorkspace.getWorkspaceId(),
                newWorkspace.getName(),
                newWorkspace.getDescription(),
                newWorkspace.getCreatedAt(),
                newWorkspace.getUpdatedAt()
        );
    }
}
