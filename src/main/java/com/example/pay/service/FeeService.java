package com.example.pay.service;

import com.example.pay.dto.FeeResponseDto;
import com.example.pay.entity.Fee;
import com.example.pay.entity.User;

import java.util.UUID;

public interface FeeService {

    FeeResponseDto getFee(UUID user, UUID recipient, long amount, int currencyCode);

}
