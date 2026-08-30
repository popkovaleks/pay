package com.example.pay.service.implementation;

import com.example.pay.dto.PaymentResponseDto;
import com.example.pay.entity.Payment;
import com.example.pay.exception.PaymentNotFoundException;
import com.example.pay.mapper.PaymentMapper;
import com.example.pay.repository.PaymentRepository;
import com.example.pay.service.NotificationService;
import com.example.pay.service.PaymentService;
import com.example.pay.service.PaymentUpdateService;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PaymentServiceImplementation implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentUpdateService paymentUpdateService;
    private final NotificationService notificationService;

    public PaymentServiceImplementation(
            PaymentRepository paymentRepository,
            PaymentUpdateService paymentUpdateService,
            NotificationService notificationService
    ) {
        this.paymentRepository = paymentRepository;
        this.paymentUpdateService = paymentUpdateService;
        this.notificationService = notificationService;
    }

    public PaymentResponseDto processPayment(UUID paymentId){
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() -> new PaymentNotFoundException(paymentId));

        PaymentMapper mapper = new PaymentMapper();
        payment = paymentUpdateService.updatePayment(payment, "PAID");

        //TODO: Добавить отправку уведомления в кафку
        notificationService.notify(payment);
        return mapper.paymentToResponseDto(payment);
    }
}
