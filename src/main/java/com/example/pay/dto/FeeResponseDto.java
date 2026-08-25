package com.example.pay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FeeResponseDto {
    private UUID id;
    private long fee;
    private long amount;
    private long totalAmount;
}
