package com.example.trelloproject.card.dto.cardCreate;

import com.example.trelloproject.card.entity.AddFile;
import com.example.trelloproject.card.entity.Manager;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CardCreateResponseDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime endAt;

    public CardCreateResponseDto(Long id, String title, String description, LocalDateTime endAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.endAt = endAt;
    }

}
