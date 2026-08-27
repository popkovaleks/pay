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
    public ResponseEntity<FeeResponseDto> getFee(Authentication authentication,
                                               @Valid @RequestBody CreatePaymentRequestDto paymentRequest){

        UUID userId = ((User) authentication.getPrincipal()).getId();


        FeeResponseDto responseFee = feeService.getFee(
                userId,
                paymentRequest.recipientId(),
                paymentRequest.amount(),
                paymentRequest.currencyCode() );
        return ResponseEntity.status(HttpStatus.CREATED).body(responseFee);

    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentResponseDto> payment(Authentication authentication,
                                     @RequestBody ConfirmPaymentRequestDto paymentRequest){

        PaymentResponseDto responsePayment = paymentService.processPayment(paymentRequest.id());

        return ResponseEntity.status(HttpStatus.CREATED).body(responsePayment);

    }

}
