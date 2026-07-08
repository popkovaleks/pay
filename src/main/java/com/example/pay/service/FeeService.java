package com.example.pay.service;

import com.example.pay.dto.FeeResponseDto;
import com.example.pay.entity.Fee;
import com.example.pay.entity.User;

public interface FeeService {

    FeeResponseDto getFee(User user, double amount, int currencyCode);

}
