package com.example.pay.mapper;

import com.example.pay.dto.FeeResponseDto;
import com.example.pay.entity.Fee;

public class FeeMapper {

    public FeeResponseDto feeToResponseDto(Fee feeEntity){
        FeeResponseDto feeDto = new FeeResponseDto();

        feeDto.setId(feeEntity.getId());
        feeDto.setValue(feeEntity.getValue());

        return feeDto;
    }
}
