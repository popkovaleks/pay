package com.example.pay.exception;

import lombok.Getter;

@Getter
public class PaymentException extends RuntimeException {
    private final String errorCode;
    private final String errorTitle;
    private final String errorDetails;

    public PaymentException(String errorCode, String errorTitle, String errorDetails) {
        super(errorDetails);
        this.errorCode = errorCode;
        this.errorTitle = errorTitle;
        this.errorDetails = errorDetails;
    }
}
