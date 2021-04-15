package dev.andrylat.task1;

import dev.andrylat.task1.service.Dialogue;
import dev.andrylat.task1.service.UserInterfaceDialogue;

public class CardValidatorApp {
    
    public static void main(String[] args) {       
        
        Dialogue userInterfaceWindow = new UserInterfaceDialogue();
        
        userInterfaceWindow.start();
                             
    }
}

