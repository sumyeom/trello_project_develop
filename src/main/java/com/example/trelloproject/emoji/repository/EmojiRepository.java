package com.example.trelloproject.emoji.repository;

import com.example.trelloproject.emoji.entity.Emoji;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmojiRepository extends JpaRepository<Emoji, Long> {
}