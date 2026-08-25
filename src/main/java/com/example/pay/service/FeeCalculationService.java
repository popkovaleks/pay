package com.example.pay.service;

import com.example.pay.entity.Payment;
import com.example.pay.entity.User;

public interface FeeCalculationService {
    Payment calculateFee(User user, User recipient, long amount);
}
