package dev.andrylat.task1.payment;

import java.util.Arrays;
import java.util.List;

public enum PaymentSystem {
    
    AMERICAN_EXPRESS("American express", "34", "37"),
    JCB("JCB", "35"),
    DINERS_CLUB("Diners club", "36", "38"),
    VISA("Visa", "4"),
    MASTERCARD("Mastercard", "5"),
    DISCOVER("Discover", "6");
    
    private String name;
    private List<String> prefixes;
    
    public String getName() {
        return name;
    }
    
    public List<String> getPrefixes() {
        return prefixes;
    }
    
    private PaymentSystem(String name, String... prefixes) {
        this.name = name;
        this.prefixes = Arrays.asList(prefixes);
    }    
}

