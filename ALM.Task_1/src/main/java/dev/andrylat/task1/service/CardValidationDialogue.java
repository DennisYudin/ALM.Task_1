package dev.andrylat.task1.service;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

import dev.andrylat.task1.cardvalidator.CardValidator;
import dev.andrylat.task1.cardvalidator.Validator;
import dev.andrylat.task1.mortgage.Mortgage;
import dev.andrylat.task1.mortgage.MortgageCalculater;
import dev.andrylat.task1.payment.Resolver;
import dev.andrylat.task1.payment.PaymentSystem;
import dev.andrylat.task1.payment.PaymentSystemIdentifier;

public class CardValidationDialogue implements Dialogue {
    
    private Resolver<PaymentSystem, String> paymentSystemIdentifier = new PaymentSystemIdentifier();
    private Validator cardValidator = new CardValidator();
    private Mortgage mortgage = new MortgageCalculater();               
    
    @Override
    public void start() {
        try (Scanner scan = new Scanner(System.in)) {
            String userAnswer;
            do {
                System.out.println("Hello. Enter card number for validation: ");
                String userInput = scan.nextLine();
                
                System.out.println(checkCardNumber(userInput));
                
                System.out.println("MORTGAGE");
                System.out.println("--------");
                
                System.out.print("Principal (1K - 100M): ");               
                int principal = scan.nextInt();
                
                System.out.print("Annual interest rate (from 1 up to 30): ");                
                float annualInterest =  scan.nextFloat();
                
                System.out.print("Period (Years) (from 1 up to 30): ");
                byte years = scan.nextByte();                
                
                System.out.print("Your monthly payment will be: ");
                double monthlyPayment = mortgage.сalculate(principal, annualInterest, years);
                
                String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);
                System.out.println(monthlyPaymentFormatted);
                
                System.out.println("Enter [yes] if you want to try again");
                System.out.print("Answer: ");
                scan.nextLine();
                userAnswer = scan.nextLine().toLowerCase();
            } while ("yes".equals(userAnswer));
        }
    }    
    
    private StringBuilder checkCardNumber(String input) {
        StringBuilder resultMessage = new StringBuilder();
        
        List<String> listErrors = cardValidator.validate(input);
        
        if (listErrors.isEmpty()) {            
            PaymentSystem paymentSystem = paymentSystemIdentifier.resolve(input);
            String paymentSystemName = paymentSystem.getName();
                                   
            resultMessage.append("Card is valid. ").append("Payment system is ")
            .append("\"").append(paymentSystemName).append("\"").append(".")
            .append("\n");                
            
        } else {            
            resultMessage.append("Card number is invalid.")
                .append("\n")
                .append("Errors:")
                .append("\n");
            
            for (String error : listErrors) {
                resultMessage.append("-> ").append(error).append("\n");                
            }
        }
        return resultMessage;
    }
}

