package com.example.pay.service.implementation;

import com.example.pay.service.SecurityService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SecurityServiceImplementation implements SecurityService {

    public UUID getUserId(String token) {
        return UUID.randomUUID();
    }
}
