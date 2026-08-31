package com.example.pay.utils;

import com.example.pay.service.CurrencyService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class MoneyConverter {

    private final CurrencyService currencyService;

    public MoneyConverter(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    public long convert(long amount, int currencyCode){
        int sourceFractionDigits = 2;
        int rubleFractionDigits = 2;
        BigDecimal rate = currencyService.getRate(currencyCode);
        BigDecimal sourceAmount = BigDecimal.valueOf(amount).movePointLeft(sourceFractionDigits);
        BigDecimal amountInRuble = sourceAmount.multiply(rate).setScale(rubleFractionDigits, RoundingMode.HALF_UP);

        return amountInRuble.movePointRight(rubleFractionDigits).longValueExact();
    }
}
