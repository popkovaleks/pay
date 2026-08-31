package com.example.pay.service;

import java.math.BigDecimal;

public interface CurrencyService {
    BigDecimal getRate(int currencyCode);
}
