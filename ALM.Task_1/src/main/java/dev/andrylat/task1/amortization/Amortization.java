package dev.andrylat.task1.amortization;

public interface Amortization {
    
    StringBuilder printAmortizationTable(double paymentInMonth, double loan, 
            float annualInterestRate, byte amountYears);    
}

