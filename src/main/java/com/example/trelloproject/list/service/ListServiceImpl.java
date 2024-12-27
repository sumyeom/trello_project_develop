package com.example.trelloproject.list.service;

import com.example.trelloproject.board.entity.Board;
import com.example.trelloproject.board.repository.BoardRepository;
import com.example.trelloproject.list.dto.ListCreateRequestDto;
import com.example.trelloproject.list.dto.ListCreateResponseDto;
import com.example.trelloproject.list.entity.BoardList;
import com.example.trelloproject.list.repository.ListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ListServiceImpl implements ListService{

    private final ListRepository listRepository;
    private final BoardRepository boardRepository;

    @Override
    public ListCreateResponseDto creatList(Long workspaceId, Long boardId, ListCreateRequestDto listCreateRequestDto) {

        Board foundBoard = boardRepository.findById(boardId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "해당하는 보드가 존재하지 않습니다."));

        // 보드아이디로 속한 리스트 갯수 세기
        Integer listCount = listRepository.countByBoardId(boardId);
        BoardList boardList = new BoardList(listCreateRequestDto.getTitle(), listCount + 1, foundBoard);
        BoardList savedBoardList = listRepository.save(boardList);

        return ListCreateResponseDto.toDto(savedBoardList);
    }
}
