package dev.andrylat.task1.service;

import java.util.Scanner;

public class UserInterfaceDialogue implements Dialogue {
    private Handler userInput = new UserInputHandler();
    
    @Override
    public void start() {
        try (Scanner scan = new Scanner(System.in)) {
            String userAnswer;
            do {
                System.out.print("Please choose a letter what do you want to do my Loard: \n"
                        + "'a' if you want to check your card number \n"
                        + "'b' if you want to calculate your monthly mortgage payment \n"
                        + "-------------------------------------------------------------\n"
                        + "Your choice my Lord: ");
                
                String userChoice = scan.nextLine().toLowerCase();
                
                userInput.acceptUserInput(userChoice, scan);
                
                System.out.println("Enter [yes] if you want to try again");
                System.out.print("Answer: ");
                
//                scan.nextLine(); <- Странная штука тут когда закоменчено то работает только 'а' :)
                userAnswer = scan.nextLine().toLowerCase();
                
            } while ("yes".equals(userAnswer));
        }
    }
}

