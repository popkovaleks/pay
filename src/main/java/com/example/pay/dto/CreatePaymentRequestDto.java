package com.example.pay.dto;

import java.util.UUID;

public record CreatePaymentRequestDto(
        long amount,
        UUID recipientId,
        int currencyCode
) {
}
