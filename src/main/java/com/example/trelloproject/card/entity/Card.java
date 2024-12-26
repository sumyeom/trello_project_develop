package com.example.trelloproject.card.entity;

import com.example.trelloproject.list.entity.BoardList;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private LocalDateTime endAt;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private BoardList boardList;


    @OneToMany(mappedBy = "card")
    private List<AddFile> fileList = new ArrayList<>();

    @OneToMany(mappedBy = "card")
    private List<UserCard> memberList = new ArrayList<>();

    public Card(){}

    public Card(String title, String description, LocalDateTime endAt, List<AddFile> fileList, List<UserCard> memberList) {
        this.title = title;
        this.description = description;
        this.endAt = endAt;
        this.fileList = fileList;
        this.memberList = memberList;
    }

    public void setTitle(String title) {
        this.title =title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }
    public void setFileList(List<AddFile> fileList){
        this.fileList = fileList;
    }
    public void setMemberList(List<UserCard> memberList) {
        this.memberList = memberList;
    }
}
