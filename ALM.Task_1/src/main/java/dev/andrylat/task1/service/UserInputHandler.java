package dev.andrylat.task1.service;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import dev.andrylat.task1.cardvalidator.CardValidator;
import dev.andrylat.task1.cardvalidator.Validator;
import dev.andrylat.task1.mortgage.Mortgage;
import dev.andrylat.task1.mortgage.MortgageCalculater;

public class UserInputHandler implements Handler {
    private Validator cardValidator = new CardValidator();
    private Mortgage mortgage = new MortgageCalculater();
    
    @Override
    public void acceptUserInput(String input, Scanner scanner) {
        
        validateUserAnswer(input);
        
        Map<Character, Runnable> commands = initCommands(scanner);
        
        commands.get(input.charAt(0)).run();
        
    }
    
    private Map<Character, Runnable> initCommands(Scanner scanner) {
        Map<Character, Runnable> commands = new HashMap<>();
        
        commands.put('a', () -> {
            
            System.out.println("Hello. Enter card number for validation: ");
            String userInput = scanner.nextLine();
            
            System.out.println(cardValidator.checkCardNumber(userInput));
        });
        commands.put('b', () -> {
            
            System.out.println("MORTGAGE");
            System.out.println("--------");
            
            System.out.print("Principal (1K - 100M): ");
            int principal = scanner.nextInt();
            
            System.out.print("Annual interest rate (from 1 up to 30): ");
            float annualInterest = scanner.nextFloat();
            
            System.out.print("Period (Years) (from 1 up to 30): ");
            byte years = scanner.nextByte();
            
            System.out.print("Your monthly payment will be: ");
            double monthlyPayment = mortgage.сalculate(principal, annualInterest, years);
            
            String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);
            System.out.println(monthlyPaymentFormatted);
        });
        return commands;
    }
    
    private void validateUserAnswer(String input) {
        if (input.charAt(0) < 'a' || input.charAt(0) > 'b' || input.length() > 1) {
            throw new IllegalArgumentException("Incorrect input.");
        }
    }
}

