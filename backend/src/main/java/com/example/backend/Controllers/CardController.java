package com.example.backend.Controllers;

import com.example.backend.Entities.Card;
import com.example.backend.Service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class CardController {

    private final ICardService cardService;

    @Autowired
    public CardController(ICardService cardService){
        this.cardService = cardService;
    }

    @GetMapping("/cards")
    public ResponseEntity<List<Card>> getAllCards(){
        List<Card> cards = cardService.getAllCards();
        if(cards != null){
            return ResponseEntity.ok().body(cards);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/card/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable String id){
        Card card = cardService.findCardById(id);
        if(card != null){
            return ResponseEntity.ok().body(card);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    //Todo MessageResponse
    @PostMapping("/card")
    public ResponseEntity<Boolean> addCard(@RequestBody Card card){
        boolean result = cardService.addCard(card);
        if(result){
            return ResponseEntity.ok().body(true);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/card/{id}")
    public ResponseEntity<Boolean> deleteCard(@PathVariable String id){
        boolean result = cardService.deleteCard(id);
        if(result){
            return ResponseEntity.ok().body(true);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/card")
    public ResponseEntity<Boolean> updateCard(@RequestBody Card card){
        boolean result = cardService.updateCard(card);
        if(result){
            return ResponseEntity.ok().body(true);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
