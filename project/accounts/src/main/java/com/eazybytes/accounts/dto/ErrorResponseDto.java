package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold ErrorResponse"
)
@Data @AllArgsConstructor
public class ErrorResponseDto {


    @Schema(
            description = "API path invoked by client", example = "/api/create"
    )
    private String apiPath;

    @Schema(
            description = "Error code representing the error happened" , example = "500"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message representing the error happened", example = "HTTP Status Internal Server Error"
    )
    private String errorMessage;

    @Schema(
            description = "Time that the error occur"
    )
    private LocalDateTime errorTime;

}
