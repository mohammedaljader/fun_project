package com.example.backend.Repositories;

import com.example.backend.Entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
    Card findCardByCardId(String cardId);
}
