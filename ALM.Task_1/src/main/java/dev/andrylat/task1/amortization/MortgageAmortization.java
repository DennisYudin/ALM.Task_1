package dev.andrylat.task1.amortization;

import java.text.NumberFormat;

public class MortgageAmortization implements Amortization {
    private static final byte PERCENT = 100;
    private static final byte MONTHS_IN_YEAR = 12;
    
    public StringBuilder printAmortizationTable(double paymentInMonth, double loan, 
            float annualInterestRate, byte amountYears) {
        
        StringBuilder amortizationTable = new StringBuilder();
        
        for (short month = 1; month <= amountYears * MONTHS_IN_YEAR; month++) {
            
            double interest = getInterest(loan, annualInterestRate);
            double principal = calculatePrincipal(paymentInMonth, loan, annualInterestRate);
            double endingBalance = calculateEndingBalance(paymentInMonth, loan, annualInterestRate);
            
            if (endingBalance < 0) {
                endingBalance = 0;
            }
            
            String startingBalanceFormatted = NumberFormat.getCurrencyInstance().format(loan);
            String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(paymentInMonth);
            String interestFormatted = NumberFormat.getCurrencyInstance().format(interest);
            String principalFormatted = NumberFormat.getCurrencyInstance().format(principal);
            String endingBalanceFormatted = NumberFormat.getCurrencyInstance().format(endingBalance);
            
            amortizationTable
                .append("Month: ").append(month).append(" ")
                .append("Startingbalance: ").append(startingBalanceFormatted).append(" ")
                .append("Monthly Payment: ").append(monthlyPaymentFormatted).append(" ")
                .append("Interest: ").append(interestFormatted).append(" ")
                .append("Principal: ").append(principalFormatted).append(" ")
                .append("Endingbalance: ").append(endingBalanceFormatted).append("\n");
            
            loan = endingBalance;
        }
        amortizationTable.deleteCharAt(amortizationTable.length() - 1);
        
        return amortizationTable;
    }
    
    private double calculateEndingBalance(double paymentInMonth, double loan, float annualInterestRate) {
        
        double principal = calculatePrincipal(paymentInMonth, loan, annualInterestRate);
        
        double balance = loan - principal;
        
        return balance;
    }
    
    private double calculatePrincipal(double paymentInMonth, double loan, float annualInterestRate) {
        
        double lenderMonthlyInterest = getInterest(loan, annualInterestRate);
        
        double principal = paymentInMonth - lenderMonthlyInterest;
        
        return principal;
    }
    
    private double getInterest(double loan, float annualInterestRate) {
        
        float monthlyInterest = getMonthlyInterest(annualInterestRate);
        
        double lenderMonthlyInterest = loan * monthlyInterest;
        
        return lenderMonthlyInterest;
    }
    
    private float getMonthlyInterest(float annualInterestRate) {
        
        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        
        return monthlyInterest;
    }    
}

