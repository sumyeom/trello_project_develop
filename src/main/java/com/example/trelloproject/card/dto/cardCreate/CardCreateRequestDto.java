package com.example.trelloproject.card.dto.cardCreate;

import com.example.trelloproject.card.entity.AddFile;
import com.example.trelloproject.card.entity.UserCard;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CardCreateRequestDto {

    private String title;
    private String description;
    private LocalDateTime endAt;
    private List<AddFile> fileList;
    private List<UserCard> memberList;


    public CardCreateRequestDto(String title, String description, LocalDateTime endAt, List<AddFile> fileList, List<UserCard> memberList) {
        this.description = description;
        this.title = title;
        this.endAt = endAt;
        this.fileList = fileList;
        this.memberList = memberList;
    }
}
