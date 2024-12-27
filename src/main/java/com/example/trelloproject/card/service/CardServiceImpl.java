package com.example.trelloproject.card.service;

import com.example.trelloproject.card.dto.cardCreate.CardCreateRequestDto;
import com.example.trelloproject.card.dto.cardCreate.CardCreateResponseDto;
import com.example.trelloproject.card.dto.cardFind.CardFindResponseDto;
import com.example.trelloproject.card.dto.cardUpdate.CardUpdateRequestDto;
import com.example.trelloproject.card.dto.cardUpdate.CardUpdateResponseDto;
import com.example.trelloproject.card.entity.Card;
import com.example.trelloproject.card.repository.CardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @Override
    public CardCreateResponseDto createCard(Long listId, CardCreateRequestDto cardCreateRequestDto) {

        Card savedCard = cardRepository.save(new Card(cardCreateRequestDto.getTitle(),
                cardCreateRequestDto.getDescription(),
                cardCreateRequestDto.getEndAt(),
                cardCreateRequestDto.getFileList(),
                cardCreateRequestDto.getManagers())
        );


        return new CardCreateResponseDto(savedCard.getId(),
                savedCard.getTitle(),
                savedCard.getDescription(),
                savedCard.getEndAt(),
                savedCard.getFileList(),
                savedCard.getManagers()
        );
    }

    @Override
    public CardUpdateResponseDto updateCard(Long cardId, CardUpdateRequestDto cardUpdateRequestDto) {

        Card findCard = cardRepository.findById(cardId)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "card doesn't exist"));

        findCard.setTitle(cardUpdateRequestDto.getNewTitle());
        findCard.setDescription(cardUpdateRequestDto.getNewDescription());
        findCard.setEndAt(cardUpdateRequestDto.getNewEndAt());
        findCard.setFileList(cardUpdateRequestDto.getNewFileList());
        findCard.setManagerList(cardUpdateRequestDto.getNewManagers());

        Card updatedCard = cardRepository.save(findCard);
        return new CardUpdateResponseDto(updatedCard.getId(), updatedCard.getTitle(), updatedCard.getDescription(), updatedCard.getEndAt(), updatedCard.getFileList(), updatedCard.getManagers());
    }

    @Override
    public CardFindResponseDto getCard(Long cardId) {

        Card findCard = cardRepository.findById(cardId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "card doesn't exist"));


        return new CardFindResponseDto(findCard.getId(),
                findCard.getTitle(),
                findCard.getDescription(),
                findCard.getEndAt(),
                findCard.getFileList(),
                findCard.getManagers());
    }

    @Override
    public void deleteCard(Long cardId) {
        //카드 조회
        Card findCard = cardRepository.findById(cardId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "card doesn't exist"));

        //카드 삭제
        cardRepository.deleteById(cardId);

    }

    @Override
    public List<CardFindResponseDto> searchAndConvertCard(String title, String description, LocalDateTime endAt, String name) {
        List<Card> cards = searchCard(title, description, endAt, name) ;
        return converToDto(cards);
    }

    private List<CardFindResponseDto> converToDto(List<Card> cards) {
        return cards.stream()
                .map(card -> new CardFindResponseDto(
                        card.getId(),
                        card.getTitle()
                ))
                .toList();
    }


    @Override
    public List<Card> searchCard(String title, String description, LocalDateTime endAt, String name) {
        return cardRepository.searchCard(title, description, endAt, name);
    }

}
