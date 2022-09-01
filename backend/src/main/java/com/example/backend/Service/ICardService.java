package com.example.backend.Service;

import com.example.backend.Entities.Card;

import java.util.List;

public interface ICardService {
    Card findCardById(String cardId);
    List<Card> getAllCards();
    boolean addCard(Card card);
    boolean deleteCard(String cardId);
    boolean updateCard(Card card);
}
