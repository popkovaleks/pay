package com.example.pay.dto;

import java.util.UUID;

public class FeeResponseDto {
    private UUID id;
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
