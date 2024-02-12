package com.eazybytes.card.service.impl;

import com.eazybytes.card.constants.CardConstants;
import com.eazybytes.card.dto.CardDto;
import com.eazybytes.card.entity.Card;
import com.eazybytes.card.exception.CardAlreadyExistsException;
import com.eazybytes.card.exception.ResourceNotFoundException;
import com.eazybytes.card.mapper.CardMapper;
import com.eazybytes.card.repository.CardRepository;
import com.eazybytes.card.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardService {

    private CardRepository cardRepository;
    @Override
    public void createCard(String mobileNumber) {
        Optional<Card> optionalCard = cardRepository.findByMobileNumber(mobileNumber);
        if(optionalCard.isPresent()){
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber "+mobileNumber);
        }
        cardRepository.save(createNewCard(mobileNumber));
    }


    private Card createNewCard(String mobileNumber){
        Card card = new Card();
        long randomCardNumber = 1000000000L + new Random().nextInt(900000000);
        card.setMobileNumber(mobileNumber);
        card.setCardNumber(randomCardNumber+"");
        card.setCardType(CardConstants.CREDIT);
        card.setTotalLimit(CardConstants.START_AMOUNT);
        card.setAmountUsed(0);
        card.setAvailableAmount(CardConstants.START_AMOUNT);

        return card;
    }

    @Override
    public CardDto fetchCard(String mobileNumber) {
        Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card" , "mobile Number" , mobileNumber));
        return CardMapper.mapToCardsDto(card , new CardDto());
    }

    @Override
    public boolean updateCard(CardDto cardDto) {
        boolean isUpdated = false;
        if( cardDto.getMobileNumber() != null){
            Card card = cardRepository.findByMobileNumber(cardDto.getMobileNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Card" , "Mobile Number", cardDto.getMobileNumber())
            );
            CardMapper.mapToCards(cardDto,card);
            cardRepository.save(card);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card" , "Mobile Number", mobileNumber)
        );
        cardRepository.deleteById(card.getCardId());
        return true;
    }
}
