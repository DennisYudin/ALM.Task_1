package dev.andrylat.task1.payment;

import dev.andrylat.task1.common.Resolver;

public class PaymentSystemResolver implements Resolver<PaymentSystem, String> {
    
    @Override
    public PaymentSystem resolve(String input) {
        
        for (PaymentSystem value : PaymentSystem.values()) {
            
            for (String prefix : value.getPrefixes()) {
                if (input.startsWith(prefix)) {                    
                    return value;
                }                
            }
        }        
        throw new IllegalArgumentException("There is no such Payment System.");
    }
}

