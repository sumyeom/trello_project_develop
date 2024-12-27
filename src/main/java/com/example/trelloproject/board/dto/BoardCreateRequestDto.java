package com.example.trelloproject.board.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class BoardCreateRequestDto {

    private final String title;
    private final MultipartFile image;

    public BoardCreateRequestDto(String title, MultipartFile image) {
        this.title = title;
        this.image = image;
    }
}
