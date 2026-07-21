package com.example.pay.service;

import javax.crypto.SecretKey;

public interface JwtService {
    SecretKey getSigningKey();
}
