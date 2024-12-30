package com.example.trelloproject.card.service;

import com.example.trelloproject.card.dto.addManager.AddManagerRequestDto;
import com.example.trelloproject.card.dto.addManager.AddManagerResponseDto;

public interface ManagerService {

    AddManagerResponseDto createManager(Long cardId, Long UserId, AddManagerRequestDto addManagerRequestDto);

    void deleteManager(Long managerId);
}
