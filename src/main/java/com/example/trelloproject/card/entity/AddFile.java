package com.example.trelloproject.card.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "add_file")
public class AddFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 원본 파일명
    @Column(nullable = false)
    private String originalFileName;

    // 저장 파일명
    @Column(nullable = false)
    private String savedFileName;

    @Column
    private String filePath;

    @Column(nullable = false)
    private String fileType;

    @Column(nullable = false)
    private Long fileSize;


    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;


    public AddFile() {

    }

    public AddFile(String originalFileName, String savedFileName, String filePath, String fileType, Long fileSize, Card card) {
        this.originalFileName = originalFileName;
        this.savedFileName = savedFileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.card = card;
    }
}
