package com.example.trelloproject.card.repository;


import com.example.trelloproject.board.entity.QBoard;
import com.example.trelloproject.card.entity.Card;
import com.example.trelloproject.card.entity.QCard;
import com.example.trelloproject.user.entity.QUser;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.trelloproject.board.entity.QBoard.board;
import static com.example.trelloproject.card.entity.QCard.card;
import static com.example.trelloproject.card.entity.QManager.manager;
import static com.example.trelloproject.user.entity.QUser.user;


@Repository
public class CardRepositoryImpl implements CardCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public CardRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Card> searchCard(String title, String description,LocalDateTime endAt, String name) {

//        return jpaQueryFactory
//                .selectFrom(card)
//                .leftJoin(card.managers, manager)
//
//                .where(titleEq(title), descriptionEq(description),endAtEq(endAt))
//                .fetch();
//    }

        JPAQuery<Card> query = jpaQueryFactory
                .selectFrom(card);
//                .leftJoin(card.managers, manager);

// managerName이 null이 아닐 경우에만 on 조건 추가
//        if (name != null) {
//            query.on(manager.managerName.eq(name));
//        }

        return query
                .where(
                        titleEq(title),
                        descriptionEq(description),
                        endAtEq(endAt)
                )
                .fetch();
    }

    private BooleanExpression titleEq(String title) {
        return title != null ? card.title.eq(title) : null;
    }
    private BooleanExpression descriptionEq(String description) {
        return description != null ? card.description.eq(description) : null;
    }
    private BooleanExpression endAtEq(LocalDateTime endAt){
        return endAt != null ? card.endAt.eq(endAt) : null;
    }
    // managerName 조건 (on 절에서 사용)
    private BooleanExpression managerNameEq(String managerName) {
        return managerName != null ? manager.managerName.eq(managerName) : null;
    }
}
