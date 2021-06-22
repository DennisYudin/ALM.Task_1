package dev.andrylat.task1;

import java.util.Scanner;

import dev.andrylat.task1.dialogs.Dialogue;
import dev.andrylat.task1.dialogs.InitialAppDialogue;

public class Application {
    
    public static void main(String[] args) {
        
        Dialogue initialAppDialogue = new InitialAppDialogue();
        
        try (Scanner scan = new Scanner(System.in)) {            
            try {
                initialAppDialogue.start(scan);
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }
        }             
    }
}

