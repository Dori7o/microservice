package com.eazybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information for the Cliente"
)
@Data
public class CustomerDto {

    @Schema(
            description = "Customer name",
            example = "Pedro"
    )
    @NotEmpty(message = "Name can not be null or empty")
    @Size(min = 5, max = 30, message = "Your name is in a wrong format")
    private String name;

    @Schema(
            description = "Email of the customer",
            example = "pedro@gmail.com"
    )
    @NotEmpty(message = "Email can not be null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            description = "Mobile Number of the customer",
            example = "0123456789"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account of the customer"
    )
    private AccountsDto accountsDto;
}
