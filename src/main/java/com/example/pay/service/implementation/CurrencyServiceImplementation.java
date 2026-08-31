package com.example.pay.service.implementation;

import com.example.pay.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyServiceImplementation implements CurrencyService {


    public BigDecimal getRate(int currencyCode) {
        return new BigDecimal("1.3");
    }
}
