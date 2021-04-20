package dev.andrylat.task1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InitialAppDialogue implements Dialogue {
    private static final String GREETING_MESSAGE = "Please choose a letter what do you want to do my Lord: \n";
    private static final String HYPHEN_SYMBOL = "-------------------------------------------------------------\n";
    private static final String FIRST_OPTION = "'a' if you want to check your card number \n";
    private static final String SECOND_OPTION = "'b' if you want to calculate your monthly mortgage payment \n";
    private static final String USER_CHOICE = "Your choice my Lord: ";
    private static final String REPEAT_MESSAGE = "Enter [yes] if you want to try again";
    private static final String USER_ANSWER = "Answer: ";
    
    private Map<String, Dialogue> dialogs = new HashMap<>();
    {        
        dialogs.put("a", new CardValidationDialogue());
        dialogs.put("b", new MortgageCalculatorDialogue());
    }
    
    @Override
    public void start(Scanner scan) {
        String userAnswer;
        do {
            System.out.print(GREETING_MESSAGE 
                    + FIRST_OPTION 
                    + SECOND_OPTION 
                    + HYPHEN_SYMBOL 
                    + USER_CHOICE);
            
            String userChoice = scan.nextLine().toLowerCase();
            
            validateUserAnswer(userChoice);            
            
            dialogs.get(userChoice).start(scan);
            
            System.out.println(REPEAT_MESSAGE);
            System.out.print(USER_ANSWER);
            
            userAnswer = scan.nextLine().toLowerCase();
            System.out.println();
            
        } while ("yes".equals(userAnswer));
    }     
    
    private void validateUserAnswer(String input) {
        
        List<String> options = new ArrayList<>();
        
        options.addAll(dialogs.keySet());
        
        if (!options.contains(input)) {
            throw new IllegalArgumentException("Incorrect input.");
        }
    }
}

