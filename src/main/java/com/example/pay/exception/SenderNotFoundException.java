package com.example.pay.exception;

import java.util.UUID;

public class SenderNotFoundException extends UserNotFoundException{
    public SenderNotFoundException(UUID userId) {
        super(userId, "Sender");
    }
}
