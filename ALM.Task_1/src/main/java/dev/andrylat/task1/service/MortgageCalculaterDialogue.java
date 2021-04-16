package dev.andrylat.task1.service;

import java.text.NumberFormat;
import java.util.Scanner;

import dev.andrylat.task1.common.Dialogue;
import dev.andrylat.task1.common.Loan;
import dev.andrylat.task1.mortgage.MortgageCalculater;

public class MortgageCalculaterDialogue implements Dialogue {
    private Loan mortgage = new MortgageCalculater();
    
    @Override
    public void start(Scanner scanner) {
        
        System.out.println("MORTGAGE");
        System.out.println("--------");
        
        System.out.print("Principal (enter value from 1K up to 100M): ");
        int principal = scanner.nextInt();
        
        System.out.print("Annual interest rate (enter value from 1 up to 30): ");
        float annualInterest = scanner.nextFloat();
        
        System.out.print("Period (Years) (enter value from 1 up to 30): ");
        byte years = scanner.nextByte();
        System.out.println();
        
        System.out.print("Your monthly payment will be: ");
        double monthlyPayment = mortgage.сalculate(principal, annualInterest, years);
        
        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);
        System.out.println(monthlyPaymentFormatted);        
        System.out.println();
        
        scanner.nextLine();
    }
}

