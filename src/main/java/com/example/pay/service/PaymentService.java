package com.example.pay.service;

import com.example.pay.dto.PaymentResponseDto;

import java.util.Currency;
import java.util.UUID;

public interface PaymentService {

    PaymentResponseDto processPayment(UUID paymentId);
}
