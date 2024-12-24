package com.example.trelloproject.list.entity;

import com.example.trelloproject.board.entity.Board;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "list")
public class BoardList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer order;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

//    @OneToMany
//    private List<Card> cards = new ArrayList<>();

    public BoardList() {}

    public BoardList(String title, Integer order, Board board) {
        this.title = title;
        this.order = order;
        this.board = board;
    }
}
