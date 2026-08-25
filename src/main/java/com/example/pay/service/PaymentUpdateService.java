package com.example.pay.service;

import com.example.pay.entity.Payment;

public interface PaymentUpdateService {
    Payment updatePayment(Payment payment, String state);
}
