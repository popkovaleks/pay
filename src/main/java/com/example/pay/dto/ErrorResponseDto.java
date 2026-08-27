package com.example.pay.dto;

import java.util.UUID;

public record ErrorResponseDto(String errorCode,
                               String errorTitle,
                               String errorDetails,
                               UUID errorId) {
}
