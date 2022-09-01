package com.example.backend.Data_access;

import com.example.backend.Entities.Card;
import com.example.backend.Repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDAL implements ICardDAL{

    private final CardRepository cardRepository;

    @Autowired
    public CardDAL(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }


    @Override
    public Card findCardById(String cardId) {
        return cardRepository.findCardByCardId(cardId);
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(Card card) {
        cardRepository.delete(card);
    }

    @Override
    public Card updateCard(Card card) {
        return cardRepository.save(card);
    }
}
