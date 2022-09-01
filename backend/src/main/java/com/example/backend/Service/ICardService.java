package com.example.backend.Service;

import com.example.backend.DTO.CardDto;
import com.example.backend.Entities.Card;

import java.util.List;

public interface ICardService {
    CardDto findCardById(String cardId);
    List<CardDto> getAllCards();
    boolean addCard(CardDto cardDto);
    boolean deleteCard(String cardId);
    boolean updateCard(CardDto cardDto);
}
