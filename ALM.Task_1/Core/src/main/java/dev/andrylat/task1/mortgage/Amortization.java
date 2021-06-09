package dev.andrylat.task1.mortgage;

public interface Amortization {
    
    double getInterest(double loan, float annualInterestRate);
    
    double calculatePrincipal(double paymentInMonth, double loan, float annualInterestRate);
    
    double calculateEndingBalance(double paymentInMonth, double loan, float annualInterestRate);
}

