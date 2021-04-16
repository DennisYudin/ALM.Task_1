package dev.andrylat.task1.service;

import java.util.Scanner;

import dev.andrylat.task1.cardvalidator.CardValidator;
import dev.andrylat.task1.common.Dialogue;
import dev.andrylat.task1.common.Validator;

public class CardValidationDialogue implements Dialogue {
    
    private Validator cardValidator = new CardValidator();
    
    @Override
    public void start(Scanner scanner) {
        
        System.out.println("Hello. Enter card number for validation: ");
        String userInput = scanner.nextLine();
        
        System.out.println(cardValidator.checkCardNumber(userInput));
        
    }
}

