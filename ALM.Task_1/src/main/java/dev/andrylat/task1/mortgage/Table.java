package dev.andrylat.task1.mortgage;

public interface Table {
    
    StringBuilder printTable(double paymentInMonth, double loan, 
            float annualInterestRate, byte amountYears);
}

