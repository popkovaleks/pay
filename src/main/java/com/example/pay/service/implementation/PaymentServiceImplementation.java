package com.example.pay.service.implementation;

import com.example.pay.dto.PaymentResponseDto;
import com.example.pay.entity.Payment;
import com.example.pay.exception.PaymentNotFoundException;
import com.example.pay.mapper.PaymentMapper;
import com.example.pay.repository.PaymentRepository;
import com.example.pay.service.PaymentService;
import com.example.pay.service.PaymentUpdateService;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PaymentServiceImplementation implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentUpdateService paymentUpdateService;

    public PaymentServiceImplementation(
            PaymentRepository paymentRepository,
            PaymentUpdateService paymentUpdateService
    ) {
        this.paymentRepository = paymentRepository;
        this.paymentUpdateService = paymentUpdateService;
    }

    public PaymentResponseDto processPayment(UUID paymentId){
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() -> new PaymentNotFoundException(paymentId));

        PaymentMapper mapper = new PaymentMapper();
        
        return mapper.paymentToResponseDto(paymentUpdateService.updatePayment(payment, "PAID"));
    }
}
