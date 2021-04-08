package dev.andrylat.task1.paymentsystemidentifier;

import java.util.Arrays;
import java.util.List;

public enum PaymentSystem {
    
    AMERICAN_EXPRESS("American express", "34", "37"),
    JCB("JCB", "35"),
    DINERS_CLUB("Diners club", "36", "38"),
    VISA("Visa", "4"),
    MASTERCARD("Mastercard", "5"),
    DISCOVER("Discover", "6");
    
    private List<String> paymentSystemData;
        
    public List<String> getPaymentSystemData() {
        return paymentSystemData;
    }

    private PaymentSystem(String... paymentSystems) {
        this.paymentSystemData = Arrays.asList(paymentSystems);
    }    
}

