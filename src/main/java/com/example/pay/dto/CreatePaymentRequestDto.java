package com.example.pay.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreatePaymentRequestDto(

        long amount,
        UUID recipientId,
        int currencyCode,
        @NotNull(message = "amount must not be null")
        @NotEmpty(message = "amount must not be empty")
        @NotBlank(message = "amount must not be blank")
        String test
) {
}
