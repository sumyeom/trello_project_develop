package com.example.trelloproject.card.dto.cardUpdate;

import com.example.trelloproject.card.entity.AddFile;
import com.example.trelloproject.card.entity.Manager;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CardUpdateRequestDto {

    private String newTitle;
    private String newDescription;
    private LocalDateTime newEndAt;

    public CardUpdateRequestDto(String newTitle, String newDescription, LocalDateTime newEndAt) {
        this.newTitle = newTitle;
        this.newDescription = newDescription;
        this.newEndAt = newEndAt;
    }
}
