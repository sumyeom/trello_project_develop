package com.example.trelloproject.board.entity;

import com.example.trelloproject.common.entity.CreateAndUpdateDateEntity;
import com.example.trelloproject.list.entity.BoardList;
import com.example.trelloproject.workspace.entity.Workspace;
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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "board")
public class Board extends CreateAndUpdateDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

//    @Column(nullable = false)
    @Column
    private File image;

    @ManyToOne
    @JoinColumn(name = "workspace_id", nullable = false)
    private Workspace workspace;

    @OneToMany(mappedBy = "board")
    private List<BoardList> boardLists = new ArrayList<>();

    public Board() {}

    public Board(String title, File image) {
        this.title = title;
        this.image = image;
    }
}
