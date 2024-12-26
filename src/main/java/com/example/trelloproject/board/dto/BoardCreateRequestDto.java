package com.example.trelloproject.board.dto;

import lombok.Getter;

import java.io.File;

@Getter
public class BoardCreateRequestDto {

    private final String title;
    private final File image;

    public BoardCreateRequestDto(String title, File image) {
        this.title = title;
        this.image = image;
    }
}
