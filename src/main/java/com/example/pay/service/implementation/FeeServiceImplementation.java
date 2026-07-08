package com.example.pay.service.implementation;

import com.example.pay.dto.FeeResponseDto;
import com.example.pay.entity.Fee;
import com.example.pay.entity.User;
import com.example.pay.mapper.FeeMapper;
import com.example.pay.repository.FeeRepository;
import com.example.pay.service.FeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeServiceImplementation implements FeeService {

    @Autowired
    private CurrencyServiceImplementation currencyService;

    @Autowired
    private FeeCalculationServiceImplementation feeCalculationService;

    public FeeResponseDto getFee(User user, double amount, int currencyCode) {
        double amountInRub = amount * currencyService.getRate(currencyCode);
        FeeMapper mapper = new FeeMapper();
        return mapper.feeToResponseDto(feeCalculationService.calculateFee(user, amountInRub));
    }


}
