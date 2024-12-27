package com.example.trelloproject.card.repository;

import com.example.trelloproject.card.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CardRepository extends JpaRepository<Card, Long>, CardCustomRepository{

}
