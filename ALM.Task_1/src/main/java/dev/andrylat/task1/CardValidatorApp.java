package dev.andrylat.task1;

import dev.andrylat.task1.service.Dialogue;

import dev.andrylat.task1.service.CardValidationDialogue;

public class CardValidatorApp {
    
    public static void main(String[] args) {
        
        Dialogue cardDialogue = new CardValidationDialogue();
        
        cardDialogue.start();
              
    }
}

