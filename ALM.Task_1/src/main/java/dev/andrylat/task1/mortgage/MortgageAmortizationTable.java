package dev.andrylat.task1.mortgage;

import java.text.NumberFormat;

public class MortgageAmortizationTable implements Table {
    private static final byte MONTHS_IN_YEAR = 12;
    
    private Amortization mortgageAmortization = new MortgageAmortization();
    
    @Override
    public StringBuilder printTable(double paymentInMonth, double loan, 
            float annualInterestRate, byte amountYears) {
        
        StringBuilder amortizationTable = new StringBuilder();
        
        for (short month = 1; month <= amountYears * MONTHS_IN_YEAR; month++) {
            
            double interest = mortgageAmortization.getInterest(loan, annualInterestRate);
            double principal = mortgageAmortization.calculatePrincipal(paymentInMonth, loan, annualInterestRate);
            double endingBalance = mortgageAmortization.calculateEndingBalance(paymentInMonth, loan, annualInterestRate);
            
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
}

