package com.eazybytes.card.dto;

import lombok.Data;

@Data
public class CardDto {

    private String mobileNumber;
    private String cardNumber;
    private String cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
}
