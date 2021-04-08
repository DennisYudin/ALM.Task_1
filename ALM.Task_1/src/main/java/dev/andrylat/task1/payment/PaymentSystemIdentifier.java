package dev.andrylat.task1.payment;

import java.util.Optional;

public class PaymentSystemIdentifier implements Resolver {
    
    @Override
    public PaymentSystem determinePaymentSystem(String input) {
        PaymentSystem paymentSystem = null;
        
        for (PaymentSystem value : PaymentSystem.values()) {
            
            for (String checkValue : value.getPaymentSystemData()) {
                if (input.startsWith(checkValue)) {
                    paymentSystem = value;
                }                
            }
        }
        validateForNull(paymentSystem);
        
        return paymentSystem;
    }
    
    private void validateForNull(PaymentSystem input) {
        Optional.ofNullable(input).orElseThrow(() -> {
            throw new IllegalArgumentException("Value is null");
        });
    }
}

