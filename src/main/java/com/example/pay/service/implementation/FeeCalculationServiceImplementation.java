package com.example.pay.service.implementation;

import com.example.pay.entity.Fee;
import com.example.pay.entity.User;
import com.example.pay.repository.FeeRepository;
import com.example.pay.service.FeeCalculationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeCalculationServiceImplementation implements FeeCalculationService {

    @Autowired
    private FeeRepository feeRepository;

    @Transactional
    public Fee calculateFee(User user, double amountInRub) {

        double feeAmount = 0;
        if (amountInRub > 5000) {
            feeAmount = amountInRub * 0.005;
        }
        if (amountInRub < 1000) {
            feeAmount = amountInRub * 0.015;
        }
        if (amountInRub >= 1000 && amountInRub <= 5000) {
            feeAmount = amountInRub * 0.01;
        }
        Fee fee = new Fee(feeAmount, user);
        feeRepository.save(fee);
        return fee;
    }
}
