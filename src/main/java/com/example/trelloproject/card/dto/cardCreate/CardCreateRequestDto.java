package com.example.trelloproject.card.dto.cardCreate;

import com.example.trelloproject.card.entity.AddFile;
import com.example.trelloproject.card.entity.Manager;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CardCreateRequestDto {

    private String title;
    private String description;
    private LocalDateTime endAt;


    public CardCreateRequestDto(String title, String description, LocalDateTime endAt) {
        this.description = description;
        this.title = title;
        this.endAt = endAt;
        this.fileList = fileList;
        this.managers = managers;
    }
}
