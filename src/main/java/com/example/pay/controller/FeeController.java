package com.example.pay.controller;

import com.example.pay.dto.FeeResponseDto;
import com.example.pay.service.implementation.FeeServiceImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fee")
public class FeeController {

    private FeeServiceImplementation feeService;

    public FeeController(FeeServiceImplementation feeService){
        this.feeService = feeService;
    }

    @GetMapping
    public ResponseEntity<FeeResponseDto> getFee(@RequestParam double amount,
                                                 @RequestParam int currencyCode){

        FeeResponseDto fee = feeService.getFee();

}
}
