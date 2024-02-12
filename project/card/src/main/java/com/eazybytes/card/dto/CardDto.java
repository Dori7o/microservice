package com.eazybytes.card.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Card",
        description = "Schema to hold Card information"
)
public class CardDto {

    @Schema(
            description = "Mobile Number associated with the card",
            example = "0123456789"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Card number",
            example = "0123456789"
    )
    @NotEmpty(message = "Card number can not be null or empty")
    private String cardNumber;

    @Schema(
            description = "Card type",
            example = "Credit"
    )
    @NotEmpty(message = "Card type can not be null or empty")
    private String cardType;

    @Schema(
            description = "Total of money this card is allowed to use"
    )
    private int totalLimit;
    @Schema(
            description = "Amount of money spend"
    )
    private int amountUsed;
    @Schema(
            description = "Amount of money still available"
    )
    private int availableAmount;
}
