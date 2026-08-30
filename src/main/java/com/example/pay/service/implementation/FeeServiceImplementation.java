package com.example.pay.service.implementation;

import com.example.pay.dto.FeeResponseDto;
import com.example.pay.entity.User;
import com.example.pay.exception.ReceiverNotFoundException;
import com.example.pay.exception.SenderEqualsToReceiverException;
import com.example.pay.exception.SenderNotFoundException;
import com.example.pay.exception.UserNotFoundException;
import com.example.pay.mapper.PaymentMapper;
import com.example.pay.repository.UserRepository;
import com.example.pay.service.FeeService;
import com.example.pay.utils.MoneyConverter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FeeServiceImplementation implements FeeService {

    private final CurrencyServiceImplementation currencyService;
    private final FeeCalculationServiceImplementation feeCalculationService;
    private final UserRepository userRepository;

    public FeeServiceImplementation(CurrencyServiceImplementation currencyService,
                                    FeeCalculationServiceImplementation feeCalculationService,
                                    UserRepository userRepository) {
        this.currencyService = currencyService;
        this.feeCalculationService = feeCalculationService;
        this.userRepository = userRepository;
    }

    public FeeResponseDto getFee(UUID userId, UUID recipientId, long amount, int currencyCode) {

        if (userId.equals(recipientId)){
            throw new SenderEqualsToReceiverException(userId);
        }
        User user = userRepository.findById(userId).orElseThrow(() -> new SenderNotFoundException(userId));
        User recipient = userRepository.findById(recipientId).orElseThrow(() -> new ReceiverNotFoundException(recipientId));

        if(currencyCode != 643){
            amount = MoneyConverter.convert(amount, currencyCode);
        }
        //TODO: Полноценная заглушка сервиса валют

        PaymentMapper mapper = new PaymentMapper();
        return mapper.feeToResponseDto(feeCalculationService.calculateFee(user, recipient, amount));
    }


}
