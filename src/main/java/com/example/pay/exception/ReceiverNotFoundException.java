package com.example.pay.exception;

import java.util.UUID;

public class ReceiverNotFoundException extends UserNotFoundException{
    public ReceiverNotFoundException(UUID userId) {
        super(userId, "Receiver");
    }
}
