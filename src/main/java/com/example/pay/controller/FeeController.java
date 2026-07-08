package com.example.pay.controller;

import com.example.pay.dto.FeeResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fee")
public class FeeController {

    @GetMapping
    public ResponseEntity<FeeResponseDto> getFee(@RequestParam double amount,
                                                 @RequestParam int currencyCode){
        

}
}
