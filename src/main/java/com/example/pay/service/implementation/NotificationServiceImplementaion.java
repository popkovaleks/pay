package com.example.pay.service.implementation;

import com.example.pay.dto.PaymentNotificatonDto;
import com.example.pay.entity.Payment;
import com.example.pay.mapper.PaymentMapper;
import com.example.pay.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class NotificationServiceImplementaion implements NotificationService {

    private final KafkaTemplate<String, PaymentNotificatonDto> kafkaTemplate;

    private static final String TOPIC = "payments";

    public void notify(Payment payment) {
        PaymentMapper mapper = new PaymentMapper();
        PaymentNotificatonDto paymentDto = mapper.paymentToNotificationDto(payment);
        kafkaTemplate.send(TOPIC, paymentDto.id().toString(), paymentDto)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.println("Отправлено в " + TOPIC + ": " + result.getRecordMetadata());
                    } else {
                        System.out.println("Ошибка отправки: " + ex.getMessage());
                    }
                });
    }
}
