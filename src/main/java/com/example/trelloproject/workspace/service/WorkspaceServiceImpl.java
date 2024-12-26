package com.example.trelloproject.workspace.service;

import com.example.trelloproject.workspace.dto.WorkspaceCreateRequestDto;
import com.example.trelloproject.workspace.dto.WorkspaceFindResponseDto;
import com.example.trelloproject.workspace.dto.WorkspaceResponseDto;
import com.example.trelloproject.workspace.entity.Workspace;
import com.example.trelloproject.workspace.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * 워크스페이스 모든 조회
     * @return 워크스페이스 리스트
     */
    @Override
    public List<WorkspaceFindResponseDto> getAllWorkspace() {
        List<Workspace> workspaces = workspaceRepository.findAll();
        if(workspaces.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"워크 스페이스를 찾을 수 없습니다.");
        }

        return workspaces.stream()
                .map(WorkspaceFindResponseDto::new)
                .collect(Collectors.toList());
    }
}
