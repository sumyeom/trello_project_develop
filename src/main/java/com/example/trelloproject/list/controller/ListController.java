package com.example.trelloproject.list.controller;

import com.example.trelloproject.list.dto.ListCreateRequestDto;
import com.example.trelloproject.list.dto.ListCreateResponseDto;
import com.example.trelloproject.list.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workspaces/{workspaceId}/boards/{boardId}/lists")
@RequiredArgsConstructor
public class ListController {

    private final ListService listService;

    // 리스트 생성
    @PostMapping
    public ResponseEntity<ListCreateResponseDto> createList(@PathVariable Long workspaceId, @PathVariable Long boardId, @RequestBody ListCreateRequestDto listCreateRequestDto) {

        ListCreateResponseDto createdList = listService.creatList(workspaceId, boardId, listCreateRequestDto);

        return new ResponseEntity<>(createdList, HttpStatus.CREATED);
    }

}
