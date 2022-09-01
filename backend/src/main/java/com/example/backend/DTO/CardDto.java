package com.example.backend.DTO;

public class CardDto {
    private String CardId;
    private String CardName;

    public CardDto(String cardId, String cardName) {
        CardId = cardId;
        CardName = cardName;
    }

    public CardDto(String cardName) {
        CardName = cardName;
    }

    public CardDto(){

    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        CardId = cardId;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }
}
