package com.example.pay.exception;

public class EmptyCurrencyException extends PaymentException{
    public EmptyCurrencyException() {
        super("EmptyCurrencyException", "No currency code were provided", "No currency code were provided");
    }
}
