package com.example.trelloproject.board.service;

import com.example.trelloproject.board.dto.BoardCreateRequestDto;
import com.example.trelloproject.board.dto.BoardCreateResponseDto;
import com.example.trelloproject.board.entity.Board;
import com.example.trelloproject.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public BoardCreateResponseDto createBoard(Long workspaceId, BoardCreateRequestDto boardCreateRequestDto) {

        Board board = new Board(boardCreateRequestDto.getTitle(), boardCreateRequestDto.getImage());
        Board savedBoard = boardRepository.save(board);

        return BoardCreateResponseDto.toDto(savedBoard);
    }

}
