package com.example.trelloproject.card.service;

import com.example.trelloproject.card.dto.cardCreate.CardCreateRequestDto;
import com.example.trelloproject.card.dto.cardCreate.CardCreateResponseDto;
import com.example.trelloproject.card.dto.cardUpdate.CardUpdateRequestDto;
import com.example.trelloproject.card.dto.cardUpdate.CardUpdateResponseDto;
import com.example.trelloproject.card.entity.Card;
import com.example.trelloproject.card.repository.CardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @Override
    public CardCreateResponseDto createCard(CardCreateRequestDto cardCreateRequestDto) {

        Card savedCard = cardRepository.save(new Card(cardCreateRequestDto.getTitle(),
                cardCreateRequestDto.getDescription(),
                cardCreateRequestDto.getEndAt(),
                cardCreateRequestDto.getFileList(),
                cardCreateRequestDto.getMemberList())
        );


        return new CardCreateResponseDto(savedCard.getId(),
                savedCard.getTitle(),
                savedCard.getDescription(),
                savedCard.getEndAt(),
                savedCard.getFileList(),
                savedCard.getMemberList()
        );
    }

    @Override
    public CardUpdateResponseDto updateCard(Long id, CardUpdateRequestDto cardUpdateRequestDto) {

        Card findCard = cardRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "card doesn't exist"));

        findCard.setTitle(cardUpdateRequestDto.getNewTitle());
        findCard.setDescription(cardUpdateRequestDto.getNewDescription());
        findCard.setEndAt(cardUpdateRequestDto.getNewEndAt());
        findCard.setFileList(cardUpdateRequestDto.getNewFileList());
        findCard.setMemberList(cardUpdateRequestDto.getNewMemberList());

        Card updatedCard = cardRepository.save(findCard);
        return new CardUpdateResponseDto(updatedCard.getId(), updatedCard.getTitle(), updatedCard.getDescription(), updatedCard.getEndAt(), updatedCard.getFileList(), updatedCard.getMemberList());
    }
}
