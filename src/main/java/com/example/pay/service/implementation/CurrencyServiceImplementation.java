package com.example.pay.service.implementation;

import com.example.pay.service.CurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImplementation implements CurrencyService {


    public double getRate(int currencyCode) {
        return 1.3;
    }
}
