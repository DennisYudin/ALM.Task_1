package dev.andrylat.task1.cardvalidator;

import java.util.ArrayList;
import java.util.List;

public class CardValidator implements Validator {
    private static final String SYMBOL_SPACE = "\\s+";
    
    @Override
    public List<String> validate(String cardNumber) {
        List<String> validateResultMessages = new ArrayList<>();
        
        cardNumber = cardNumber.replaceAll(SYMBOL_SPACE, "");
        
        validateResultMessages.addAll(validateForLength(cardNumber));
        validateResultMessages.addAll(validateForDigits(cardNumber));
        validateResultMessages.addAll(validateForLuhnAlgorithm(cardNumber));
        
        return validateResultMessages;
    }
    
    private List<String> validateForLength(String input) {
        List<String> listErrors = new ArrayList<>();
        
        int cardLength = 16;
        String errorMessage = "Length should be 16 symbols";
        
        if (input.length() != cardLength) {
            listErrors.add(errorMessage);
        }
        return listErrors;
    }
    
    private List<String> validateForDigits(String input) {
        List<String> listErrors = new ArrayList<>();
        
        String regexCardNumber = "[0-9]+";
        String errorMessage = "Number should contain only digits";
        
        if (!input.matches(regexCardNumber)) {
            listErrors.add(errorMessage);
        }
        return listErrors;
    }
    
    private List<String> validateForLuhnAlgorithm(String input) {
        List<String> listErrors = new ArrayList<>();
        
        int totalSum = 0;
        int numberCardLength = input.length();
        int maxEvenNumber = 9;
        String errorMessage = "Payment system can't be determine";
        
        for (int positionNumber = 0; positionNumber < numberCardLength; positionNumber++) {
            char number = input.charAt(positionNumber);
            int currentNumber = Character.getNumericValue(number);
            int calculationResult;
            
            if (positionNumber % 2 != 0) {
                totalSum += currentNumber;
            } else {
                calculationResult = currentNumber * 2;
                
                if (calculationResult > maxEvenNumber) {
                    calculationResult -= 9;
                    totalSum += calculationResult;
                } else {
                    totalSum += calculationResult;
                }
            }
        }
        if (totalSum % 10 != 0) {
            listErrors.add(errorMessage);
        }
        return listErrors;
    }
}

