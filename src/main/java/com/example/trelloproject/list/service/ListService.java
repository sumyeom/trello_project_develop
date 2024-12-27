package com.example.trelloproject.list.service;

import com.example.trelloproject.list.dto.ListCreateRequestDto;
import com.example.trelloproject.list.dto.ListCreateResponseDto;

public interface ListService {

   ListCreateResponseDto creatList(Long workspaceId, Long boardId, ListCreateRequestDto listCreateRequestDto);
}
