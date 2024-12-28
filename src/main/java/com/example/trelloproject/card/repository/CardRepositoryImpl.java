package com.example.trelloproject.card.repository;


import com.example.trelloproject.card.entity.Card;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.trelloproject.board.entity.QBoard.board;
import static com.example.trelloproject.card.entity.QCard.card;
import static com.example.trelloproject.user.entity.QUser.user;


@Repository
public class CardRepositoryImpl implements CardCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public CardRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Card> searchCard(String title, String description,LocalDateTime endAt, String name) {
        return jpaQueryFactory
                .selectFrom(card)
                .where(titleEq(title), descriptionEq(description),endAtEq(endAt), user.name.eq(name), board.title.eq(title))
                .fetch();
    }

    private BooleanExpression descriptionEq(String title) {
        return title != null ? card.title.eq(title) : card.title.isNull();
    }
    private BooleanExpression titleEq(String description) {
        return description != null ? card.description.eq(description) : card.description.isNull();
    }
    private BooleanExpression endAtEq(LocalDateTime endAt){
        return endAt != null ? card.endAt.eq(endAt) : card.endAt.isNull();
    }
}
