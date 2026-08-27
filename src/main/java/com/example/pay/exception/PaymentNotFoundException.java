package com.example.pay.exception;

import java.util.UUID;

public class PaymentNotFoundException extends PaymentException {
    public PaymentNotFoundException(UUID paymentId) {
        super("PaymentNotFoundException", "Can't proccess payment. Please, try again later", "Payment not found " + paymentId);
    }
}
