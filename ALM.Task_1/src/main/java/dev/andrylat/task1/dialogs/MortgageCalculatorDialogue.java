package dev.andrylat.task1.dialogs;

import java.text.NumberFormat;
import java.util.Scanner;

import dev.andrylat.task1.console.Console;
import dev.andrylat.task1.mortgage.Loan;
import dev.andrylat.task1.mortgage.MortgageCalculator;

public class MortgageCalculatorDialogue implements Dialogue {
    private static final String TITLE_MESSAGE = "MORTGAGE";
    private static final String HYPHEN_SYMBOL = "--------";
    private static final String PRINCIPAL_MESSAGE = "Principal (enter value from 1K up to 100M): ";
    private static final String ANNUAL_INTEREST_MESSAGE = "Annual interest rate (enter value from 1 up to 30): ";
    private static final String PERIOD_MESSAGE = "Period (Years) (enter value from 1 up to 30): ";
    private static final String RESULT_MESSAGE = "Your monthly payment will be: ";
    
    private static final byte MIN_ALLOWED_VALUE = 1;
    private static final byte MAX_ALLOWED_VALUE = 30;
    private static final int MIN_PRINCIPAL_VALUE = 1_000;
    private static final int MAX_PRINCIPAL_VALUE = 100_000_000; 
    
    private Loan mortgage = new MortgageCalculator();
    private Console console = new Console();

    @Override
    public void start(Scanner scanner) {
        
        printTitle();
        
        int principal = (int)console.readNumber(PRINCIPAL_MESSAGE, MIN_PRINCIPAL_VALUE, MAX_PRINCIPAL_VALUE, scanner);
        float annualInterest = (float)console.readNumber(ANNUAL_INTEREST_MESSAGE, MIN_ALLOWED_VALUE, MAX_ALLOWED_VALUE, scanner);
        byte years = (byte)console.readNumber(PERIOD_MESSAGE, MIN_ALLOWED_VALUE, MAX_ALLOWED_VALUE, scanner);
        
        System.out.println();
        
        System.out.print(RESULT_MESSAGE);
        double monthlyPayment = mortgage.calculate(principal, annualInterest, years);
        
        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);
        System.out.println(monthlyPaymentFormatted);
        System.out.println();
        
        scanner.nextLine();
    }
    
    private void printTitle() {
        System.out.println(TITLE_MESSAGE);
        System.out.println(HYPHEN_SYMBOL);
    }            
}

