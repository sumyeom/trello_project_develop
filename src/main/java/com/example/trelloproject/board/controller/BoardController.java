package com.example.trelloproject.board.controller;

import com.example.trelloproject.board.dto.BoardCreateRequestDto;
import com.example.trelloproject.board.dto.BoardCreateResponseDto;
import com.example.trelloproject.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workspaces/{workspaceId}/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 보드 생성
    @PostMapping
    public ResponseEntity<BoardCreateResponseDto> createBoard(@PathVariable Long workspaceId, @RequestBody BoardCreateRequestDto boardCreateRequestDto) {

        BoardCreateResponseDto createdBoard = boardService.createBoard(workspaceId, boardCreateRequestDto);

        return new ResponseEntity<>(createdBoard, HttpStatus.CREATED);
    }

    // 보드 다건 조회
    @GetMapping
    public ResponseEntity<List<BoardCreateResponseDto>> findAllBoard(@PathVariable Long workspaceId) {

        List<BoardCreateResponseDto> foundBoards = boardService.findAllBoard(workspaceId);

        return new ResponseEntity<>(foundBoards, HttpStatus.OK);
    }

}