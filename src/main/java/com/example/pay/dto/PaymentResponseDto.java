package com.example.pay.dto;

import java.util.UUID;

public record PaymentResponseDto(
        UUID id,
        boolean isPaid
) {
}
