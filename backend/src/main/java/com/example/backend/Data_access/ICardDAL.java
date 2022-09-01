package com.example.backend.Data_access;

import com.example.backend.Entities.Card;

import java.util.List;

public interface ICardDAL {
    Card findCardById(String cardId);
    List<Card> getAllCards();
    Card addCard(Card card);
    void deleteCard(Card card);
    Card updateCard(Card card);
}
