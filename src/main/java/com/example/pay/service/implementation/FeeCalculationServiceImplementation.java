package com.example.pay.service.implementation;

import com.example.pay.entity.Payment;
import com.example.pay.entity.User;
import com.example.pay.repository.PaymentRepository;
import com.example.pay.service.FeeCalculationService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FeeCalculationServiceImplementation implements FeeCalculationService {

    private PaymentRepository paymentRepository;

    public FeeCalculationServiceImplementation(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public Payment calculateFee(User user, User recipient, long amountInRub) {
        int fractionDigits = 2;
        BigDecimal amount = BigDecimal.valueOf(amountInRub).movePointLeft(fractionDigits);
        BigDecimal feeAmount = new BigDecimal("0");
        if (amount.compareTo(new BigDecimal("5000")) > 0) {
            feeAmount = amount.multiply(new BigDecimal("0.005"));
        } else if (amount.compareTo(new BigDecimal("1000")) < 0) {
            feeAmount = amount.multiply(new BigDecimal("0.015"));
        } else {
            feeAmount = amount.multiply(new BigDecimal("0.01"));
        }
        Payment payment = new Payment(
                amount.movePointRight(fractionDigits).longValueExact(),
                user,
                recipient,
                feeAmount.movePointRight(fractionDigits).longValueExact()
        );
        paymentRepository.save(payment);
        return payment;
    }
}
