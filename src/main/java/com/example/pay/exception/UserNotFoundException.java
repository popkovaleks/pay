package com.example.pay.exception;

import java.util.UUID;

public class UserNotFoundException extends UserException{


    public UserNotFoundException(UUID userId, String roleInPayment) {
        super(userId, "UserNotFoundException", roleInPayment + " not found", "User not found: " + userId);
    }

}
