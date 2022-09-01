package com.example.backend.Service;


import com.example.backend.DTO.CardDto;
import com.example.backend.Data_access.ICardDAL;
import com.example.backend.Entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService implements ICardService {
    private final ICardDAL cardDAL;

    @Autowired
    public CardService(ICardDAL cardDAL){
        this.cardDAL = cardDAL;
    }

    @Override
    public CardDto findCardById(String cardId) {
        Card card =  cardDAL.findCardById(cardId);
        return new CardDto(card.getCardId(), card.getCardName());
    }

    @Override
    public List<CardDto> getAllCards() {
        List<Card> cards =  cardDAL.getAllCards();
        List<CardDto> cardDtos = new ArrayList<>();
        for (Card card: cards) {
            CardDto cardDto = new CardDto(card.getCardId(), card.getCardName());
            cardDtos.add(cardDto);
        }
        return cardDtos;
    }

    @Override
    public boolean addCard(CardDto cardDto) {
        Card card = new Card(cardDto.getCardName());
        return cardDAL.addCard(card) != null;
    }

    @Override
    public boolean deleteCard(String cardId) {
        Card card = cardDAL.findCardById(cardId);
        cardDAL.deleteCard(card);
        return cardDAL.findCardById(card.getCardId()) == null;
    }

    @Override
    public boolean updateCard(CardDto cardDto) {
        Card oldCard = cardDAL.findCardById(cardDto.getCardId());
        oldCard.setCardName(cardDto.getCardName());
        return cardDAL.updateCard(oldCard) != null;
    }
}
