package dev.andrylat.task1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dev.andrylat.task1.common.Dialogue;
import dev.andrylat.task1.common.Window;

public class StartWindow implements Window {
    
    @Override    
    public void start() {
        try (Scanner scan = new Scanner(System.in)) {
            String userAnswer;
            do {
                System.out.print("Please choose a letter what do you want to do my Lord: \n"
                        + "'a' if you want to check your card number \n"
                        + "'b' if you want to calculate your monthly mortgage payment \n"
                        + "-------------------------------------------------------------\n"
                        + "Your choice my Lord: ");
                
                String userChoice = scan.nextLine().toLowerCase();
                
                validateUserAnswer(userChoice);
                
                Map<String, Dialogue> dialogs = initCommands();
                                
                dialogs.get(userChoice).start(scan);
                
                System.out.println("Enter [yes] if you want to try again");
                System.out.print("Answer: "); 
                
                userAnswer = scan.nextLine().toLowerCase();
                System.out.println(); 
                
            } while ("yes".equals(userAnswer));
        }
    }
    
    private Map<String, Dialogue> initCommands() {
        
        Map<String, Dialogue> dialogs = new HashMap<>();
        
        dialogs.put("a", new CardValidationDialogue());
        dialogs.put("b", new MortgageCalculaterDialogue());
        
        return dialogs;
    }
    
    private void validateUserAnswer(String input) {
        
        List<String> options = new ArrayList<>();
        
        options.add("a");
        options.add("b");
        
        if (!options.contains(input)) {
            throw new IllegalArgumentException("Incorrect input.");
        }
    }
}

