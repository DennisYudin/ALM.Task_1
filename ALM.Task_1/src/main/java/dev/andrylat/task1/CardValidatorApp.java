package dev.andrylat.task1;

import dev.andrylat.task1.service.Dialogue;
import dev.andrylat.task1.service.UserInterface;

public class CardValidatorApp {
    
    public static void main(String[] args) {
        
        Dialogue userInterface = new UserInterface();
        
        userInterface.showInputWindow();
    }
}

