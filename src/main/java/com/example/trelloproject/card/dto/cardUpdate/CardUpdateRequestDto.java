package com.example.trelloproject.card.dto.cardUpdate;

import com.example.trelloproject.card.entity.AddFile;
import com.example.trelloproject.card.entity.UserCard;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CardUpdateRequestDto {

    private String newTitle;
    private String newDescription;
    private LocalDateTime newEndAt;
    private List<AddFile> newFileList;
    private List<UserCard> newManagers;

    public CardUpdateRequestDto(String newTitle, String newDescription, LocalDateTime newEndAt, List<AddFile> newFileList, List<UserCard> newManagers) {
        this.newTitle = newTitle;
        this.newDescription = newDescription;
        this.newEndAt = newEndAt;
        this.newFileList = newFileList;
        this.newManagers = newManagers;
    }
}
