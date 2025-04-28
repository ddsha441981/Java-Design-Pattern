package com.cwc.adapter.pattern.payload;

import com.cwc.adapter.pattern.model.enums.Statuss;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class PaymentResponse {
    private Statuss status;
    private String transactionId = UUID.randomUUID().toString();
    private LocalDateTime timestamp;
}
