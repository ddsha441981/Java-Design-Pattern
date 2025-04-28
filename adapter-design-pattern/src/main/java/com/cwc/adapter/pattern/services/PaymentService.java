package com.cwc.adapter.pattern.services;

import com.cwc.adapter.pattern.payload.PaymentRequest;
import com.cwc.adapter.pattern.payload.PaymentResponse;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest request);
}
