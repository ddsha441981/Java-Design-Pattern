package com.cwc.adapter.pattern.services.impl;

import com.cwc.adapter.pattern.payload.PaymentRequest;
import com.cwc.adapter.pattern.payload.PaymentResponse;
import com.cwc.adapter.pattern.services.ModernPaymentGateway;
import com.cwc.adapter.pattern.services.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final ModernPaymentGateway modernPaymentGateway;

    public PaymentServiceImpl(ModernPaymentGateway modernPaymentGateway) {
        this.modernPaymentGateway = modernPaymentGateway;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        String accountId = UUID.randomUUID().toString();
        request.setAccountId(accountId);
        return modernPaymentGateway.processPayment(request);
    }
}
