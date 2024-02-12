package com.eazybytes.card.service;

import com.eazybytes.card.dto.CardDto;

public interface ICardService {

    void createCard(String mobileNumber);

    CardDto fetchCard(String mobileNumber);

    boolean updateCard(CardDto cardDto);

    boolean deleteAccount(String mobileNumber);
}
