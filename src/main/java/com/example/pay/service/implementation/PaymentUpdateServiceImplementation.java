package com.example.pay.service.implementation;

import com.example.pay.entity.Payment;
import com.example.pay.repository.PaymentRepository;
import com.example.pay.service.PaymentUpdateService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PaymentUpdateServiceImplementation implements PaymentUpdateService {

    private final PaymentRepository paymentRepository;

    PaymentUpdateServiceImplementation(
            PaymentRepository paymentRepository
    ){
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public Payment updatePayment(Payment payment, String state) {
        if (state.matches("PAID")){
            payment.setPaid(true);
        }

        paymentRepository.save(payment);

        return payment;
    }
}
