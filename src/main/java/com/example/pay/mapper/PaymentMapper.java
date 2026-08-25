package com.example.pay.mapper;

import com.example.pay.dto.FeeResponseDto;
import com.example.pay.dto.PaymentResponseDto;
import com.example.pay.entity.Payment;

public class PaymentMapper {

    public FeeResponseDto feeToResponseDto(Payment payment){
        FeeResponseDto feeDto = new FeeResponseDto();

        feeDto.setId(payment.getId());
        feeDto.setFee(payment.getFee());
        feeDto.setAmount(payment.getAmount());
        feeDto.setTotalAmount(payment.getTotalAmount());


        return feeDto;
    }

    public PaymentResponseDto paymentToResponseDto(Payment payment) {
        return new PaymentResponseDto(
                payment.getId(),
                payment.isPaid());
    }
}
