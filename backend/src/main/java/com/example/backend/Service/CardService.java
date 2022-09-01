package com.example.backend.Service;


import com.example.backend.Data_access.ICardDAL;
import com.example.backend.Entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService implements ICardService {
    private final ICardDAL cardDAL;

    @Autowired
    public CardService(ICardDAL cardDAL){
        this.cardDAL = cardDAL;
    }

    @Override
    public Card findCardById(String cardId) {
        return cardDAL.findCardById(cardId);
    }

    @Override
    public List<Card> getAllCards() {
        return cardDAL.getAllCards();
    }

    @Override
    public boolean addCard(Card card) {
        return cardDAL.addCard(card) != null;
    }

    @Override
    public boolean deleteCard(String cardId) {
        Card card = cardDAL.findCardById(cardId);
        cardDAL.deleteCard(card);
        return cardDAL.findCardById(card.getCardId()) == null;
    }

    @Override
    public boolean updateCard(Card card) {
        Card oldCard = cardDAL.findCardById(card.getCardId());
        oldCard.setCardName(card.getCardName());
        return cardDAL.updateCard(oldCard) != null;
    }
}
