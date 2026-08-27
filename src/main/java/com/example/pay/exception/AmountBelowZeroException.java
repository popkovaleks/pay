package com.example.pay.exception;

public class AmountBelowZeroException extends PaymentException{
    public AmountBelowZeroException(String amount) {
        super("AmountBelowZeroException", "Amount less than 0 ", "Amount is " + amount);
    }
}
