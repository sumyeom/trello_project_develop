package com.example.trelloproject.card.dto.cardCreate;

import com.example.trelloproject.card.dto.cardUpdate.CardUpdateResponseDto;
import com.example.trelloproject.card.entity.AddFile;
import com.example.trelloproject.card.entity.UserCard;
import com.example.trelloproject.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public class CardCreateResponseDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime endAt;
    private List<AddFile> fileList;
    private List<UserCard> memberList;

    public CardCreateResponseDto(Long id, String title, String description, LocalDateTime endAt, List<AddFile> fileList, List<UserCard> memberList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.endAt = endAt;
        this.fileList = fileList;
        this.memberList = memberList;
    }
}
