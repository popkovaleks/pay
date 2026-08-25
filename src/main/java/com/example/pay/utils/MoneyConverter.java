package com.example.pay.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyConverter {
    public static long convert(long amount, int currencyCode){
        int sourceFractionDigits = 2;
        int rubleFractionDigits = 2;
        BigDecimal rate = new BigDecimal("1.3");
        BigDecimal sourceAmount = BigDecimal.valueOf(amount).movePointLeft(sourceFractionDigits);
        BigDecimal amountInRuble = sourceAmount.multiply(rate).setScale(rubleFractionDigits, RoundingMode.HALF_UP);

        return amountInRuble.movePointRight(rubleFractionDigits).longValueExact();
    }
}
