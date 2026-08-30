package com.example.pay.dto;

import java.util.UUID;

public record PaymentNotificatonDto(
        UUID id,
        UUID senderId,
        UUID recipientId,
        String amount,
        String fee,
        String totalAmount
){}
