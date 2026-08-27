package com.example.pay.controller;

import com.example.pay.dto.*;
import com.example.pay.entity.User;
import com.example.pay.service.PaymentService;
import com.example.pay.service.implementation.FeeServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/pay")
public class PaymentController {

    private FeeServiceImplementation feeService;
    private PaymentService paymentService;

    public PaymentController(
            FeeServiceImplementation feeService,
            PaymentService paymentService
    ){
        this.feeService = feeService;
        this.paymentService = paymentService;
    }

    @PostMapping("/getFee")
    public ResponseEntity<?> getFee(Authentication authentication,
                                               @Valid @RequestBody CreatePaymentRequestDto paymentRequest){

        UUID userId = ((User) authentication.getPrincipal()).getId();

        if (userId.equals(paymentRequest.recipientId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(1, "You can't pay to yourself"));
        }

        FeeResponseDto responseFee = feeService.getFee(
                userId,
                paymentRequest.recipientId(),
                paymentRequest.amount(),
                paymentRequest.currencyCode() );
        return ResponseEntity.status(HttpStatus.CREATED).body(responseFee);

    }

    @PostMapping("/payment")
    public ResponseEntity<?> payment(Authentication authentication,
                                     @RequestBody ConfirmPaymentRequestDto paymentRequest){

        PaymentResponseDto responsePayment = paymentService.processPayment(paymentRequest.id());

        return ResponseEntity.status(HttpStatus.CREATED).body(responsePayment);

    }

}
