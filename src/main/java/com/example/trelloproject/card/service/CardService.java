package com.example.trelloproject.card.service;

import com.example.trelloproject.card.dto.cardCreate.CardCreateRequestDto;
import com.example.trelloproject.card.dto.cardCreate.CardCreateResponseDto;
import com.example.trelloproject.card.dto.cardUpdate.CardUpdateRequestDto;
import com.example.trelloproject.card.dto.cardUpdate.CardUpdateResponseDto;

public interface CardService {
    CardCreateResponseDto createCard(CardCreateRequestDto cardCreateRequestDto);
    CardUpdateResponseDto updateCard(Long id, CardUpdateRequestDto cardUpdateRequestDto);
//    public Card getCard(String id);

//    public List<Card> getCards();
//    public void deleteCard(String id);

}

