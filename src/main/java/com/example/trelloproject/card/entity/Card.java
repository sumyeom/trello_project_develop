package com.example.trelloproject.card.entity;

import com.example.trelloproject.list.entity.BoardList;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
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

}
