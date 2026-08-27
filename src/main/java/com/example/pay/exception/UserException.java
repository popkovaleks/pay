package com.example.pay.exception;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserException extends RuntimeException {
    private final UUID userId;
    private final String errorCode;
    private final String errorTitle;
    private final String errorDetails;


    public UserException(UUID userId, String errorCode, String errorTitle, String errorDetails) {
        super(errorDetails);
        this.userId = userId;
        this.errorCode = errorCode;
        this.errorTitle = errorTitle;
        this.errorDetails = errorDetails;
    }

}
