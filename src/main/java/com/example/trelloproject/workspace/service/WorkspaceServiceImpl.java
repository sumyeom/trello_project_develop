package com.example.trelloproject.workspace.service;

import com.example.trelloproject.user.config.auth.UserDetailsImpl;
import com.example.trelloproject.user.entity.User;
import com.example.trelloproject.user.enumclass.MemberRole;
import com.example.trelloproject.workspace.dto.WorkspaceRequestDto;
import com.example.trelloproject.workspace.dto.WorkspaceFindResponseDto;
import com.example.trelloproject.workspace.dto.WorkspaceResponseDto;
import com.example.trelloproject.workspace.entity.Workspace;
import com.example.trelloproject.workspace.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceService {
    private final WorkspaceRepository workspaceRepository;
    // 추가 사항
    private final UserWorkspaceService userWorkspaceService;

    @Transactional
    @Override
    public WorkspaceResponseDto createWorkspace(WorkspaceRequestDto requestDto) {
        //TODO: 유저 멤버 역할 확인 필요
        Workspace workspace = new Workspace(requestDto.getName(), requestDto.getDescription());
        Workspace newWorkspace = workspaceRepository.save(workspace);

        // 추가 사항
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        userWorkspaceService.createUserWorkspace(user.getId(), workspace.getWorkspaceId(), "temp", MemberRole.WSADMIN);

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

    /**
     * 워크스페이스 업데이트
     * @param id
     * @param requestDto
     * @return
     */
    @Transactional
    @Override
    public WorkspaceResponseDto updateWorkspace(Long id, WorkspaceRequestDto requestDto) {

        Workspace findWorkspace = workspaceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        findWorkspace.updateWorkspace(requestDto.getName(), requestDto.getDescription());
        Workspace updateWorkspace = workspaceRepository.save(findWorkspace);
        return new WorkspaceResponseDto(
                updateWorkspace.getWorkspaceId(),
                updateWorkspace.getName(),
                updateWorkspace.getDescription(),
                updateWorkspace.getCreatedAt(),
                updateWorkspace.getUpdatedAt());
    }

    /**
     * 워크스페이스 삭제
     * @param id
     */
    @Transactional
    @Override
    public void deleteWorkspace(Long id) {

        workspaceRepository.deleteById(id);
    }


}
