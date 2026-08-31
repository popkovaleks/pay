package com.example.pay.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;

public interface JwtService {
    SecretKey getSigningKey();
    String generateToken(UserDetails userDetails);
    Claims extractClaims(String token);
    String extractUsername(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
    String extractExpirationIn(String token);
}
