package com.example.trelloproject.card.entity;

import com.example.trelloproject.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.action.internal.OrphanRemovalAction;
import org.hibernate.annotations.Fetch;

@Entity
@Getter
@Table(name="manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String managerName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    public Manager(Long id, String managerName) {
        this.id = id;
        this.managerName = managerName;
    }

    public Manager() {
    }


    public Manager(String managerName, User user, Card card) {
        this.managerName = managerName;
        this.user = user;
        this.card = card;
    }
}
