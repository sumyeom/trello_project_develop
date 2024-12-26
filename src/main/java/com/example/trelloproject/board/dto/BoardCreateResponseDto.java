package com.example.trelloproject.board.dto;

import com.example.trelloproject.board.entity.Board;
import lombok.Getter;

import java.io.File;
import java.time.LocalDateTime;

@Getter
public class BoardCreateResponseDto {

    private final Long boardId;
    private final Long workspaceId;
    private final String title;
    private final File image;
    private final LocalDateTime createdAt;
    private final LocalDateTime updateAt;

    public BoardCreateResponseDto(Long boardId, Long workspaceId, String title, File image, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.boardId = boardId;
        this.workspaceId = workspaceId;
        this.title = title;
        this.image = image;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public static BoardCreateResponseDto toDto(Board savedBoard) {
        return new BoardCreateResponseDto(
                savedBoard.getId(),
                savedBoard.getWorkspace().getWorkspaceId(),
                savedBoard.getTitle(),
                savedBoard.getImage(),
                savedBoard.getCreatedAt(),
                savedBoard.getUpdatedAt()
        );
    }
}
