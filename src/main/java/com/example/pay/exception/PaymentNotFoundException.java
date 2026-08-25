package com.example.pay.exception;

import java.util.UUID;

public class PaymentNotFoundException extends RuntimeException {

    private final UUID paymentId;

    public PaymentNotFoundException(UUID paymentId) {
        super("Payment not found " + paymentId);
        this.paymentId = paymentId;
    }

    public UUID getPaymentId(){
      return paymentId;
    }
}
