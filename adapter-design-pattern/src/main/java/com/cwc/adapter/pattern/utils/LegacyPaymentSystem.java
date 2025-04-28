package com.cwc.adapter.pattern.utils;

import org.springframework.stereotype.Component;

@Component
public class LegacyPaymentSystem {

    public boolean makePayment(String accountId, double amount, String currency) {
        // Legacy payment processing logic
        System.out.println("Processing payment of " + amount + " " + currency + " for account: " + accountId);
        return true;
    }
}
