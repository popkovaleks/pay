package com.example.pay.service;

import java.util.UUID;

public interface SecurityService {
    UUID getUserId(String token);
}
