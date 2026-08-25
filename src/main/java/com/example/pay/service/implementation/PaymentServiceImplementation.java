package com.example.pay.service.implementation;

import com.example.pay.dto.PaymentResponseDto;
import com.example.pay.entity.Fee;
import com.example.pay.entity.Payment;
import com.example.pay.entity.User;
import com.example.pay.exception.PaymentNotFoundException;
import com.example.pay.mapper.PaymentMapper;
import com.example.pay.repository.FeeRepository;
import com.example.pay.repository.PaymentRepository;
import com.example.pay.repository.UserRepository;
import com.example.pay.service.PaymentService;
import com.example.pay.service.PaymentUpdateService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.UUID;

@Service
public class PaymentServiceImplementation implements PaymentService {
    private final PaymentRepository paymentRepository;


//    private NotificationRestClient notificationRestClient = new NotificationRestClient();
//    private CbrRestClient cbrRestClient = new CbrRestClient();
//    private final CurrencyServiceImplementation currencyService;
    private final PaymentUpdateService paymentUpdateService;

    public PaymentServiceImplementation(
            PaymentRepository paymentRepository,
            CurrencyServiceImplementation currencyService,
            PaymentUpdateService paymentUpdateService
    ) {
        this.paymentRepository = paymentRepository;
//        this.currencyService = currencyService;
        this.paymentUpdateService = paymentUpdateService;
    }

    public PaymentResponseDto processPayment(UUID paymentId){
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() -> new PaymentNotFoundException(paymentId));

        PaymentMapper mapper = new PaymentMapper();

        return mapper.paymentToResponseDto(paymentUpdateService.updatePayment(payment, "PAID"));
    }

//    @Transactional
//    public void processPayment(double amount, int currencyCode, Long recipientId) {
//        double amountInRub = amount * currencyService.getRate(currencyCode);
////        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        User user = userRepository.findUserById(userId).get();
//        Payment payment = new Payment(amountInRub, user, recipientId);
//        paymentRepository.save(payment);
//        if (amountInRub < 1000) {
//            Fee fee = new Fee(amountInRub * 0.015, user);
//            feeRepository.save(fee);
//        }
//        if (amountInRub > 1000) {
//            Fee fee = new Fee(amountInRub * 0.01, user);
//            feeRepository.save(fee);
//        }
//        if (amountInRub > 5000) {
//            Fee fee = new Fee(amountInRub * 0.005, user);
//            feeRepository.save(fee);
//        }
//        try {
//            notificationRestClient.notify(payment);
//        } catch (Throwable t) {
//            // do nothing
//        }
//    }
}
