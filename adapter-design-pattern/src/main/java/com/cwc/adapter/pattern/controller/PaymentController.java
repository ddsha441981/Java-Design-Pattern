package com.cwc.adapter.pattern.controller;
import com.cwc.adapter.pattern.payload.PaymentRequest;
import com.cwc.adapter.pattern.payload.PaymentResponse;
import com.cwc.adapter.pattern.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public PaymentResponse processPayment(@RequestBody PaymentRequest request) {
        return paymentService.processPayment(request);
    }
}

