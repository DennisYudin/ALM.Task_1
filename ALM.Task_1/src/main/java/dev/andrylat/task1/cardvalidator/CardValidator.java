package dev.andrylat.task1.cardvalidator;

import java.util.ArrayList;
import java.util.List;

public class CardValidator implements Validator {
    private static final String SYMBOL_SPACE = "\\s+";
    private static final int MAX_CARD_LENGTH = 16;
    private static final String REGEX_CARD_NUMBER = "[0-9]+";
    private static final int MAX_EVEN_NUMBER = 9;    
    
    @Override
    public List<String> validate(String cardNumber) {
        List<String> validateResultMessages = new ArrayList<>();
        
        cardNumber = cardNumber.replaceAll(SYMBOL_SPACE, "");
        validateForLength(cardNumber, MAX_CARD_LENGTH, validateResultMessages);
        validateForDigits(cardNumber, REGEX_CARD_NUMBER, validateResultMessages);
        validateForLuhnAlgorithm(cardNumber, MAX_EVEN_NUMBER, validateResultMessages);
        
        return validateResultMessages;
    }
    
    private void validateForLength(String input, int length, List<String> errorsData) {
        String error = "Length should be 16 symbols";
        
        if (input.length() != length && !errorsData.contains(error)) {
            errorsData.add(error);
        }
    }
    
    private void validateForDigits(String input, String regexExpression, List<String> errorsData) {
        String error = "Number should contain only digits";
        
        if (!input.matches(regexExpression) && !errorsData.contains(error)) {
            errorsData.add(error);
        }
    }
    
    private void validateForLuhnAlgorithm(String input, int maxEvenNumber, List<String> errorsData) {
        int totalSum = 0;
        int numberCardLength = input.length();
        String error = "Payment system can't be determine";
        
        if (errorsData.isEmpty()) {            
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
            if (totalSum % 10 != 0 && !errorsData.contains(error)) {
                errorsData.add(error);
            }
        } else {
            errorsData.add(error);
        }
    }
}

