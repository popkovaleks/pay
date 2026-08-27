package com.example.pay.exception;

public class AmountEqualsZeroException extends PaymentException{
    public AmountEqualsZeroException() {
        super("AmountEqualsZeroException", "Amount is 0", "Amount is 0");
    }
}
