package dev.andrylat.task1;

import java.util.Scanner;

import dev.andrylat.task1.service.Dialogue;
import dev.andrylat.task1.service.InitialAppDialogue;

public class Application {
    
    public static void main(String[] args) {       
        
        Dialogue initialAppDialogue = new InitialAppDialogue();
        
        try (Scanner scan = new Scanner(System.in)) {
            
            initialAppDialogue.start(scan);        
        }                                   
    }
}

