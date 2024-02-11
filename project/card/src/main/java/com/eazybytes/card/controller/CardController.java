package com.eazybytes.card.controller;

import com.eazybytes.card.constants.CardConstants;

import com.eazybytes.card.dto.ResponseDto;
import com.eazybytes.card.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/card", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CardController {

     private ICardService iCardService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam String mobileNumber){
        iCardService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(CardConstants.STATUS_201, CardConstants.MESSAGE_201));
    }
}
