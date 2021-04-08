package dev.andrylat.task1.service;

import java.util.List;
import java.util.Scanner;

import dev.andrylat.task1.cardvalidator.CardValidator;
import dev.andrylat.task1.cardvalidator.Validator;
import dev.andrylat.task1.paymentsystemidentifier.Identifier;
import dev.andrylat.task1.paymentsystemidentifier.PaymentSystem;
import dev.andrylat.task1.paymentsystemidentifier.PaymentSystemIdentifier;

public class UserInterface {
    private Identifier paymentSystemIdentifier = new PaymentSystemIdentifier();
    private Validator cardValidator = new CardValidator();    
    
    public void showInputWindow() {
        try (Scanner scan = new Scanner(System.in)) {
            String userAnswer;
            do {
                System.out.println("Hello. Enter card number for validation: ");
                String userInput = scan.nextLine();
                
                System.out.println(checkCardNumber(userInput));                
                
                System.out.println("Enter [yes] if you try again");
                System.out.print("Answer: ");
                userAnswer = scan.nextLine().toLowerCase();
            } while ("yes".equals(userAnswer));
        }
    }    
    
    private StringBuilder checkCardNumber(String input) {
        StringBuilder resultMessage = new StringBuilder();
        
        cardValidator.validate(input);
        
        List<String> amountErrors = cardValidator.validate(input);
        
        if (amountErrors.isEmpty()) {            
            PaymentSystem paymentSystem = paymentSystemIdentifier.determinePaymentSystem(input);
            String paymentSystemName = paymentSystem.getPaymentSystemData().get(0);
            
            resultMessage.append("Card is valid. ").append("Payment system is ")
                .append("\"").append(paymentSystemName).append("\"").append(".")
                .append("\n");
            
        } else {            
            resultMessage.append("Card number is invalid.")
                .append("\n")
                .append("Errors:")
                .append("\n");
            
            for (String error : amountErrors) {
                resultMessage.append("-> ").append(error).append("\n");                
            }
        }
        return resultMessage;
    }
}

