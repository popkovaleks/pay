package com.example.pay.dto;


public record AuthResponse(
        String token,
        String expiresIn
) {
}
