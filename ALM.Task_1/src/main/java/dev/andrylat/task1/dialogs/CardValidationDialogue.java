package dev.andrylat.task1.service;

import java.util.List;
import java.util.Scanner;

import dev.andrylat.task1.cardvalidator.CardValidator;
import dev.andrylat.task1.cardvalidator.Validator;
import dev.andrylat.task1.payment.PaymentSystem;
import dev.andrylat.task1.payment.PaymentSystemResolver;
import dev.andrylat.task1.payment.Resolver;

public class CardValidationDialogue implements Dialogue {
    
    private Validator cardValidator = new CardValidator();
    private Resolver<PaymentSystem, String> paymentSystemResolver = new PaymentSystemResolver();
    
    @Override
    public void start(Scanner scanner) {
        
        System.out.println("Hello. Enter card number for validation: ");
        String userInput = scanner.nextLine();
        
        System.out.println(checkCardNumber(userInput));
        
    }
    
    private StringBuilder checkCardNumber(String input) {
        StringBuilder resultMessage = new StringBuilder();
        
        List<String> listErrors = cardValidator.validate(input);
        
        if (listErrors.isEmpty()) {
            PaymentSystem paymentSystem = paymentSystemResolver.resolve(input);
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

