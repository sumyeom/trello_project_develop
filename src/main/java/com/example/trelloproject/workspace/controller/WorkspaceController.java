package com.example.trelloproject.workspace.controller;

import com.example.trelloproject.workspace.dto.WorkspaceCreateRequestDto;
import com.example.trelloproject.workspace.dto.WorkspaceResponseDto;
import com.example.trelloproject.workspace.entity.Workspace;
import com.example.trelloproject.workspace.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workspaces")
@RequiredArgsConstructor
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    @PostMapping
    public ResponseEntity<WorkspaceResponseDto> createWorkspace(
            @RequestBody WorkspaceCreateRequestDto requestDto
    ){
        WorkspaceResponseDto responseDto = workspaceService.createWorkspace(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
