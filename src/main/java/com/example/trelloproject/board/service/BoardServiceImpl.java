package com.example.trelloproject.board.service;

import com.example.trelloproject.board.dto.BoardCreateRequestDto;
import com.example.trelloproject.board.dto.BoardCreateResponseDto;
import com.example.trelloproject.board.entity.Board;
import com.example.trelloproject.board.repository.BoardRepository;
import com.example.trelloproject.workspace.entity.Workspace;
import com.example.trelloproject.workspace.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final WorkspaceRepository workspaceRepository;

    @Override
    public BoardCreateResponseDto createBoard(Long workspaceId, BoardCreateRequestDto boardCreateRequestDto) {

        Workspace foundWorkspace = workspaceRepository.findById(workspaceId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "해당하는 워크스페이스가 존재하지 않습니다."));

        Board board = new Board(boardCreateRequestDto.getTitle(), boardCreateRequestDto.getImage(), foundWorkspace );
        Board savedBoard = boardRepository.save(board);

        return BoardCreateResponseDto.toDto(savedBoard);
    }

    @Override
    public List<BoardCreateResponseDto> findAllBoard(Long workspaceId) {

        List<Board> boardList = boardRepository.findAll();

        return boardList.stream().map(BoardCreateResponseDto::toDto).toList();
    }
}
