package com.cwc.adapter.pattern.adapter;

import com.cwc.adapter.pattern.model.enums.Statuss;
import com.cwc.adapter.pattern.payload.PaymentRequest;
import com.cwc.adapter.pattern.payload.PaymentResponse;
import com.cwc.adapter.pattern.services.ModernPaymentGateway;
import com.cwc.adapter.pattern.utils.LegacyPaymentSystem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class LegacyPaymentAdapter implements ModernPaymentGateway {
    private final LegacyPaymentSystem legacyPaymentSystem;

    public LegacyPaymentAdapter(LegacyPaymentSystem legacyPaymentSystem) {
        this.legacyPaymentSystem = legacyPaymentSystem;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        boolean success = legacyPaymentSystem.makePayment(
                paymentRequest.getAccountId(),
                paymentRequest.getAmount(),
                paymentRequest.getCurrency()
        );

        return createPaymentResponse(success);
    }

    private PaymentResponse createPaymentResponse(boolean success) {
            return PaymentResponse.builder()
                    .status(success ? Statuss.SUCCESS : Statuss.FAILURE)
                    .transactionId(UUID.randomUUID().toString())
                    .timestamp(LocalDateTime.now())
                    .build();
    }
}
