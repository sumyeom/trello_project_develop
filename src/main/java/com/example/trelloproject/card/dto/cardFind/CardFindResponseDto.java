package com.example.trelloproject.card.dto.cardFind;

import com.example.trelloproject.card.entity.AddFile;
import com.example.trelloproject.card.entity.Card;
import com.example.trelloproject.card.entity.UserCard;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CardFindResponseDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime endAt;
    private List<AddFile> fileList;
    private List<UserCard> memberList;
//    private List<Comment> comments

    public CardFindResponseDto(Long id, String title, String description, LocalDateTime endAt, List<AddFile> fileList, List<UserCard> memberList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.endAt = endAt;
        this.fileList = fileList;
        this.memberList = memberList;
    }

    public CardFindResponseDto(Long id, String title){
        this.id = id;
        this.title = title;
    }
}
