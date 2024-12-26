package com.example.trelloproject.board.dto;

import com.example.trelloproject.board.entity.Board;
import com.example.trelloproject.list.entity.BoardList;
import com.example.trelloproject.workspace.entity.Workspace;
import lombok.Getter;

import java.io.File;
import java.time.LocalDateTime;

@Getter
public class BoardFindResponseDto {

    private final Long boardId;
    private final Long workspaceId;
    private final String title;
    private final File image;
    //    private final List<BoardListResponseDto> boards;
    private final LocalDateTime createdAt;
    private final LocalDateTime updateAt;

    public BoardFindResponseDto(Long boardId, Long workspaceId, String title, File image, LocalDateTime createdAt, LocalDateTime updateAt) {

        this.boardId = boardId;
        this.workspaceId = workspaceId;
        this.title = title;
        this.image = image;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public static BoardFindResponseDto toDto(Board board, Workspace workspace) {

        return new BoardFindResponseDto(
                board.getId(),
                workspace.getWorkspaceId(),
                board.getTitle(),
                board.getImage(),
                board.getCreatedAt(),
                board.getUpdatedAt()
        );
    }
}