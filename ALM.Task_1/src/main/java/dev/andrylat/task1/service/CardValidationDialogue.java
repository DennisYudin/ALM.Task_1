package dev.andrylat.task1.service;

import java.util.List;
import java.util.Scanner;

import dev.andrylat.task1.cardvalidator.CardValidator;
import dev.andrylat.task1.cardvalidator.Validator;
import dev.andrylat.task1.payment.Resolver;
import dev.andrylat.task1.payment.PaymentSystem;
import dev.andrylat.task1.payment.PaymentSystemIdentifier;

public class CardValidationDialogue implements Dialogue {
    
    private Resolver<PaymentSystem, String> paymentSystemIdentifier = new PaymentSystemIdentifier();
    private Validator cardValidator = new CardValidator();    
    
    @Override
    public void start() {
        try (Scanner scan = new Scanner(System.in)) {
            String userAnswer;
            do {
                System.out.println("Hello. Enter card number for validation: ");
                String userInput = scan.nextLine();
                
                System.out.println(checkCardNumber(userInput));                
                
                System.out.println("Enter [yes] if you want to try again");
                System.out.print("Answer: ");
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

