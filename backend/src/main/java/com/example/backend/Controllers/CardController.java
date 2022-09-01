package com.example.backend.Controllers;

import com.example.backend.DTO.CardDto;
import com.example.backend.DTO.MessageResponse;
import com.example.backend.Service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CardController {

    private final ICardService cardService;

    @Autowired
    public CardController(ICardService cardService){
        this.cardService = cardService;
    }

    @GetMapping("/cards")
    public ResponseEntity<List<CardDto>> getAllCards(){
        List<CardDto> cards = cardService.getAllCards();
        if(cards != null){
            return ResponseEntity.ok().body(cards);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/card/{id}")
    public ResponseEntity<CardDto> getCardById(@PathVariable String id){
        CardDto card = cardService.findCardById(id);
        if(card != null){
            return ResponseEntity.ok().body(card);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/card")
    public ResponseEntity<MessageResponse> addCard(@RequestBody CardDto cardDto){
        boolean result = cardService.addCard(cardDto);
        if(result){
            return ResponseEntity.ok().body(new MessageResponse("Card added successfully!!"));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/card/{id}")
    public ResponseEntity<MessageResponse> deleteCard(@PathVariable String id){
        boolean result = cardService.deleteCard(id);
        if(result){
            return ResponseEntity.ok().body(new MessageResponse("Card deleted successfully!!"));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/card")
    public ResponseEntity<MessageResponse> updateCard(@RequestBody CardDto cardDto){
        boolean result = cardService.updateCard(cardDto);
        if(result){
            return ResponseEntity.ok().body(new MessageResponse("Card updated successfully!!"));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
