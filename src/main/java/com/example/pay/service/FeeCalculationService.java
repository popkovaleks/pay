package com.example.pay.service;

import com.example.pay.entity.Fee;
import com.example.pay.entity.User;

public interface FeeCalculationService {
    Fee calculateFee(User user, double amount);
}
