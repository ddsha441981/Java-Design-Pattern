package com.cwc.adapter.pattern.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class PaymentRequest {
    private String accountId;
    private double amount;
    private String currency;
}
