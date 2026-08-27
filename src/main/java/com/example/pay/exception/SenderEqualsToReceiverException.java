package com.example.pay.exception;

import java.util.UUID;

public class SenderEqualsToReceiverException extends UserException{
    public SenderEqualsToReceiverException(UUID userId) {
        super(userId, "SenderEqualsToReceiverException", "Can't pay to yourself", "Sender userId equals to receiver userId: " + userId);
    }
}
