package dev.andrylat.task1.paymentsystemidentifier;

import java.util.Optional;

public class PaymentSystemIdentifier implements Identifier {
    
    @Override
    public PaymentSystem determinePaymentSystem(String input) {
        PaymentSystem paymentSystem = null;
        
        for (PaymentSystem value : PaymentSystem.values()) {
            int amountCheckValues = value.getPaymentSystemData().size();
            
            for (int currentCheckValue = 1; currentCheckValue < amountCheckValues; currentCheckValue++) {
                String checkNumbers = value.getPaymentSystemData().get(currentCheckValue);
                
                if (input.startsWith(checkNumbers)) {
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

