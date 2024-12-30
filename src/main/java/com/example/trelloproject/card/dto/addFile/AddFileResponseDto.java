package com.example.trelloproject.card.dto.addFile;

import lombok.Getter;

@Getter
public class AddFileResponseDto {

    private Long id;
    private String filePath;
    private String fileName;
    private String fileType;

    public AddFileResponseDto(Long id, String filePath, String fileName, String fileType) {
        this.id = id;
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileType = fileType;
    }
}
