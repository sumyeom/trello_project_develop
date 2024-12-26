package com.example.trelloproject.card.controller;

import com.example.trelloproject.card.dto.cardCreate.CardCreateRequestDto;
import com.example.trelloproject.card.dto.cardCreate.CardCreateResponseDto;
import com.example.trelloproject.card.dto.cardUpdate.CardUpdateRequestDto;
import com.example.trelloproject.card.dto.cardUpdate.CardUpdateResponseDto;
import com.example.trelloproject.card.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workspaces/{workspaceId}/boards/{boardId}/lists/{listId}/cards")
public class CardController {

    public final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    // 카드 생성
    @PostMapping
    public ResponseEntity<CardCreateResponseDto> createCard(@RequestBody CardCreateRequestDto cardCreateRequestDto) {
        return new ResponseEntity<>(cardService.createCard(cardCreateRequestDto), HttpStatus.CREATED);
    }

    // 카드 수정
    @PatchMapping
    public ResponseEntity<CardUpdateResponseDto> updateCard(
            @PathVariable Long cardId,
            @RequestBody CardUpdateRequestDto cardUpdateRequestDto
    ) {
        return new ResponseEntity<>(cardService.updateCard(cardId, cardUpdateRequestDto),HttpStatus.OK);
    }


    // 카드 단건 조회


    // 카드 삭제






}
