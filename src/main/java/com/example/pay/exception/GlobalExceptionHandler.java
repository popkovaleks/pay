package com.example.pay.exception;


import com.example.pay.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({PaymentException.class,
            EmptyCurrencyException.class,
            AmountBelowZeroException.class,
            AmountEqualsZeroException.class
    })
    public ResponseEntity<ErrorResponseDto> handlePaymentException(PaymentException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(
                ex.getErrorCode(),
                ex.getErrorTitle(),
                ex.getErrorDetails(),
                UUID.randomUUID()
                )
        );
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handlePaymentNotFoundException(PaymentNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
                        ex.getErrorCode(),
                        ex.getErrorTitle(),
                        ex.getErrorDetails(),
                        UUID.randomUUID()
                )
        );
    }

    @ExceptionHandler({ReceiverNotFoundException.class, SenderNotFoundException.class})
    public ResponseEntity<ErrorResponseDto> handleUserNotFoundException(UserNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(
                        ex.getErrorCode(),
                        ex.getErrorTitle(),
                        ex.getErrorDetails(),
                        UUID.randomUUID()
                )
        );
    }


    @ExceptionHandler(SenderEqualsToReceiverException.class)
    public ResponseEntity<ErrorResponseDto> handleSenderEqualsToReceiverException(SenderEqualsToReceiverException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(
                        ex.getErrorCode(),
                        ex.getErrorTitle(),
                        ex.getErrorDetails(),
                        UUID.randomUUID()
                )
        );
    }
}
