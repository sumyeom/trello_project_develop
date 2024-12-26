package com.example.trelloproject.workspace.controller;

import com.example.trelloproject.workspace.dto.WorkspaceRequestDto;
import com.example.trelloproject.workspace.dto.WorkspaceFindResponseDto;
import com.example.trelloproject.workspace.dto.WorkspaceResponseDto;
import com.example.trelloproject.workspace.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspaces")
@RequiredArgsConstructor
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    /**
     * 워크스페이스 생성 API
     * @param requestDto
     * @return
     */
    @PostMapping
    public ResponseEntity<WorkspaceResponseDto> createWorkspace(
            @RequestBody WorkspaceRequestDto requestDto
    ){
        WorkspaceResponseDto responseDto = workspaceService.createWorkspace(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    /**
     * 워크스페이스 조회 API
     * @return
     */
    @GetMapping
    public ResponseEntity<List<WorkspaceFindResponseDto>> getAllWorkspace() {
        List<WorkspaceFindResponseDto> responseDtos = workspaceService.getAllWorkspace();
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    /**
     * 워크스페이스 업데이트 API
     * @param id
     * @param requestDto
     * @return
     */
    @PatchMapping("/{id}")
    public ResponseEntity<WorkspaceResponseDto> updateWorkspace(
            @PathVariable Long id,
            @RequestBody WorkspaceRequestDto requestDto
    ){
        WorkspaceResponseDto responseDto = workspaceService.updateWorkspace(id, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     *  워크스페이스 삭제 API
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkspace(
            @PathVariable Long id
    ){
        workspaceService.deleteWorkspace(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
