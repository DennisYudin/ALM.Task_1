package dev.andrylat.task1.service;

import java.text.NumberFormat;
import java.util.Scanner;

import dev.andrylat.task1.mortgage.Loan;
import dev.andrylat.task1.mortgage.MortgageCalculator;

public class MortgageCalculatorDialogue implements Dialogue {
    private static final String TITLE_MESSAGE = "MORTGAGE";
    private static final String HYPHEN_SYMBOL = "--------";
    private static final String PRINCIPAL_MESSAGE = "Principal (enter value from 1K up to 100M): ";
    private static final String ANNUAL_INTEREST_MESSAGE = "Annual interest rate (enter value from 1 up to 30): ";
    private static final String PERIOD_MESSAGE = "Period (Years) (enter value from 1 up to 30): ";
    private static final String RESULT_MESSAGE = "Your monthly payment will be: ";
    
    private Loan mortgage = new MortgageCalculator();

    @Override
    public void start(Scanner scanner) {
        
        System.out.println(TITLE_MESSAGE);
        System.out.println(HYPHEN_SYMBOL);
        
        System.out.print(PRINCIPAL_MESSAGE);
        int principal = scanner.nextInt();
        
        System.out.print(ANNUAL_INTEREST_MESSAGE);
        float annualInterest = scanner.nextFloat();
        
        System.out.print(PERIOD_MESSAGE);
        byte years = scanner.nextByte();
        System.out.println();
        
        System.out.print(RESULT_MESSAGE);
        double monthlyPayment = mortgage.сalculate(principal, annualInterest, years);
        
        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);
        System.out.println(monthlyPaymentFormatted);
        System.out.println();
        
        scanner.nextLine();
    }
}

