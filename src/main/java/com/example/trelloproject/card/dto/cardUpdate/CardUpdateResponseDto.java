package com.example.trelloproject.card.dto.cardUpdate;

import com.example.trelloproject.card.entity.AddFile;
import com.example.trelloproject.card.entity.UserCard;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CardUpdateResponseDto {

    private Long id;
    private String newTitle;
    private String newDescription;
    private LocalDateTime newEndAt;
    private List<AddFile> newFileList;
    private List<UserCard> newMemberList;

    public CardUpdateResponseDto(Long id, String newTitle, String newDescription, LocalDateTime newEndAt, List<AddFile> newFileList, List<UserCard> newMemberList) {
        this.id = id;
        this.newTitle = newTitle;
        this.newDescription = newDescription;
        this.newEndAt = newEndAt;
        this.newFileList = newFileList;
        this.newMemberList = newMemberList;
    }
}
