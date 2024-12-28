package com.example.trelloproject.card.service;

import com.example.trelloproject.card.dto.cardCreate.CardCreateRequestDto;
import com.example.trelloproject.card.dto.cardCreate.CardCreateResponseDto;
import com.example.trelloproject.card.dto.cardFind.CardFindResponseDto;
import com.example.trelloproject.card.dto.cardUpdate.CardUpdateRequestDto;
import com.example.trelloproject.card.dto.cardUpdate.CardUpdateResponseDto;
import com.example.trelloproject.card.entity.Card;

import java.time.LocalDateTime;
import java.util.List;


public interface CardService {
    CardCreateResponseDto createCard(Long listId, CardCreateRequestDto cardCreateRequestDto);

    CardUpdateResponseDto updateCard(Long cardId, CardUpdateRequestDto cardUpdateRequestDto);

    CardFindResponseDto getCard(Long cardId);

    void deleteCard(Long cardId);

    List<CardFindResponseDto> searchAndConvertCard(String title, String description, LocalDateTime endAt, String name);

    List<Card> searchCard(String title, String description, LocalDateTime endAt, String name);
}

