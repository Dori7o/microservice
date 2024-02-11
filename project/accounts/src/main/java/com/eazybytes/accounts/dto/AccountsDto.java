package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
@Data
public class AccountsDto {

    @Schema(
            description = "Account number",
            example = "1003452795"
    )
    @NotEmpty (message = "Account number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of Bank account",
            example = "Savings"
    )
    @NotEmpty (message = "Account type can not be null or empty")
    private String accountType;

    @Schema(
            description = "Branch Address",
            example = "123rd, Cool Street"
    )
    @NotEmpty (message = "Branch address can not be null or empty")
    private String branchAddress;
}
