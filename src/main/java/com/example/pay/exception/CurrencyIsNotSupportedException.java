package com.example.pay.exception;

public class CurrencyIsNotSupportedException extends PaymentException{
    public CurrencyIsNotSupportedException(String currency){
        super("CurrencyIsNotSupportedException", "Currency is not supported", "Currency " + currency + " is not supported");
    }
}
