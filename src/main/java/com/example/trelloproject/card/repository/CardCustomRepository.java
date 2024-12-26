package com.example.trelloproject.card.repository;

import com.example.trelloproject.card.entity.Card;

import java.util.List;

public interface CardCustomRepository {
    List<Card> findCardByTitle(String title);
}
