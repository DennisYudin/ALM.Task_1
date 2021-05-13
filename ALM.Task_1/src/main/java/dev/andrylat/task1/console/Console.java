package dev.andrylat.task1.console;

import java.util.Scanner;

public class Console {
    
    public double readNumber(String prompt, double min, double max, Scanner scanner) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("You should enter a value between " + min + " and " + max);
        }
        return value;
    }
}

