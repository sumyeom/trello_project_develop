package com.example.trelloproject.card.dto.cardCreate;

import com.example.trelloproject.card.entity.AddFile;
import com.example.trelloproject.card.entity.UserCard;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CardCreateResponseDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime endAt;
    private List<AddFile> fileList;
    private List<UserCard> managers;

    public CardCreateResponseDto(Long id, String title, String description, LocalDateTime endAt, List<AddFile> fileList, List<UserCard> managers) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.endAt = endAt;
        this.fileList = fileList;
        this.managers = managers;
    }
}
