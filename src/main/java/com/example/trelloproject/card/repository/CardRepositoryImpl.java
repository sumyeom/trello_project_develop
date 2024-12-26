package com.example.trelloproject.card.repository;


//import com.example.trelloproject.card.entity.QCard;
//import com.example.trelloproject.card.entity.Card;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;

//@Repository
//public class CardRepositoryImpl implements CardCustomRepository {

//    private final JPAQueryFactory jpaQueryFactory;
//
//    QCard card = QCard.card;
//
//    public CardRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
//        this.jpaQueryFactory = jpaQueryFactory;
//    }
//
//    @Override
//    public List<Card> findCardByTitle(String title) {
//        return jpaQueryFactory
//                .selectFrom(card)
//                .where(card.title.eq(title))
//                .fetch();
//    }
//}
