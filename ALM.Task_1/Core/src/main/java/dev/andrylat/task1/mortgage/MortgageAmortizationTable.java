package dev.andrylat.task1.mortgage;

import java.text.NumberFormat;

import dev.andrylat.task1.domain.Data;

public class MortgageAmortizationTable implements Table {
    private static final byte MONTHS_IN_YEAR = 12;
    
    private Amortization mortgageAmortization = new MortgageAmortization();
    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
    
    @Override
    public StringBuilder printTable(Data dataObject) {
        
        double paymentInMonth = dataObject.getPaymentInMonth();
        double loan = dataObject.getLoan();
        float annualInterestRate = dataObject.getAnnualInterestRate();
        byte amountYears = dataObject.getAmountYears();
        
        StringBuilder amortizationTable = new StringBuilder();
        
        for (short month = 1; month <= amountYears * MONTHS_IN_YEAR; month++) {
            
            double interest = mortgageAmortization.getInterest(loan, annualInterestRate);
            double principal = mortgageAmortization.calculatePrincipal(paymentInMonth, loan, annualInterestRate);
            double endingBalance = mortgageAmortization.calculateEndingBalance(paymentInMonth, loan, annualInterestRate);
            
            if (endingBalance < 0) {
                endingBalance = 0;
            }
            
            String startingBalanceFormatted = numberFormat.format(loan);
            String monthlyPaymentFormatted = numberFormat.format(paymentInMonth);
            String interestFormatted = numberFormat.format(interest);
            String principalFormatted = numberFormat.format(principal);
            String endingBalanceFormatted = numberFormat.format(endingBalance);
            
            amortizationTable.append("Month: ").append(month).append(" ")
                .append("Startingbalance: ").append(startingBalanceFormatted).append(" ")
                .append("Monthly payment: ").append(monthlyPaymentFormatted).append(" ")
                .append("Interest: ").append(interestFormatted).append(" ")
                .append("Principal: ").append(principalFormatted).append(" ")
                .append("Endingbalance: ").append(endingBalanceFormatted).append("\n");
            
            loan = endingBalance;
        }
        amortizationTable.deleteCharAt(amortizationTable.length() - 1);
        
        return amortizationTable;
    }
}

