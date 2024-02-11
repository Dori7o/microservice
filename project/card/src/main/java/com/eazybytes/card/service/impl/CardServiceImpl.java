package com.eazybytes.card.service.impl;

import com.eazybytes.card.dto.CardDto;
import com.eazybytes.card.entity.Card;
import com.eazybytes.card.repository.CardRepository;
import com.eazybytes.card.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardService {

    private CardRepository cardRepository;
    @Override
    public void createCard(String mobileNumber) {

        cardRepository.save(createNewCard(mobileNumber));
    }

    private Card createNewCard(String mobileNumber){
        Card card = new Card();
        long randomCardNumber = 1000000000L + new Random().nextInt(900000000);
        card.setMobileNumber(mobileNumber);
        card.setCardNumber(randomCardNumber+"");
        card.setCardType("Savings");
        card.setTotalLimit(1000);
        card.setAmountUsed(0);
        card.setAvailableAmount(1000);


        return card;
    }
}
