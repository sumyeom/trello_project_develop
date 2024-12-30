package com.example.trelloproject.card.dto.cardUpdate;

import com.example.trelloproject.card.entity.AddFile;
import com.example.trelloproject.card.entity.Manager;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CardUpdateResponseDto {

    private Long id;
    private String newTitle;
    private String newDescription;
    private LocalDateTime newEndAt;

    public CardUpdateResponseDto(Long id, String newTitle, String newDescription, LocalDateTime newEndAt) {
        this.id = id;
        this.newTitle = newTitle;
        this.newDescription = newDescription;
        this.newEndAt = newEndAt;
    }
}
