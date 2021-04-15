package dev.andrylat.task1.cardvalidator;

import java.util.ArrayList;
import java.util.List;

import dev.andrylat.task1.payment.PaymentSystem;
import dev.andrylat.task1.payment.PaymentSystemIdentifier;
import dev.andrylat.task1.payment.Resolver;

public class CardValidator implements Validator {
    private Resolver<PaymentSystem, String> paymentSystemIdentifier = new PaymentSystemIdentifier();
    
    private static final String SYMBOL_SPACE = "\\s+";
    private static final int CARD_LENGTH = 16;
    private static final int MAX_EVEN_NUMBER = 9;
    private static final String REGEX_CARD_NUMBER = "[0-9]+";
    private static final String LENGTH_ERROR_MESSAGE = "Length should be 16 symbols";
    private static final String DIGITS_ERROR_MESSAGE = "Number should contain only digits";
    private static final String PAYMENT_SYSTEM_ERROR_MESSAGE = "Payment system can't be determine";
    
    @Override
    public StringBuilder checkCardNumber(String input) {
        StringBuilder resultMessage = new StringBuilder();
        
        List<String> listErrors = validate(input);
        
        if (listErrors.isEmpty()) {            
            PaymentSystem paymentSystem = paymentSystemIdentifier.resolve(input);
            String paymentSystemName = paymentSystem.getName();
                                   
            resultMessage.append("Card is valid. ").append("Payment system is ")
            .append("\"").append(paymentSystemName).append("\"").append(".")
            .append("\n");                
            
        } else {            
            resultMessage.append("Card number is invalid.")
                .append("\n")
                .append("Errors:")
                .append("\n");
            
            for (String error : listErrors) {
                resultMessage.append("-> ").append(error).append("\n");                
            }
        }
        return resultMessage;
    }
    
    private List<String> validate(String cardNumber) {
        List<String> validateResultMessages = new ArrayList<>();
        
        cardNumber = cardNumber.replaceAll(SYMBOL_SPACE, "");
        
        validateResultMessages.addAll(validateForLength(cardNumber));
        validateResultMessages.addAll(validateForDigits(cardNumber));
        validateResultMessages.addAll(validateForLuhnAlgorithm(cardNumber));
        
        return validateResultMessages;
    }
    
    private List<String> validateForLength(String input) {
        List<String> errors = new ArrayList<>();
        
        if (input.length() != CARD_LENGTH) {
            errors.add(LENGTH_ERROR_MESSAGE);
        }
        return errors;
    }
    
    private List<String> validateForDigits(String input) {
        List<String> errors = new ArrayList<>();
        
        if (!input.matches(REGEX_CARD_NUMBER)) {
            errors.add(DIGITS_ERROR_MESSAGE);
        }
        return errors;
    }
    
    private List<String> validateForLuhnAlgorithm(String input) {
        List<String> errors = new ArrayList<>();
        
        int totalSum = 0;
        int numberCardLength = input.length();
        
        for (int positionNumber = 0; positionNumber < numberCardLength; positionNumber++) {
            char number = input.charAt(positionNumber);
            int currentNumber = Character.getNumericValue(number);
            int calculationResult;
            
            if (positionNumber % 2 != 0) {
                totalSum += currentNumber;
            } else {
                calculationResult = currentNumber * 2;
                
                if (calculationResult > MAX_EVEN_NUMBER) {
                    calculationResult -= 9;
                    totalSum += calculationResult;
                } else {
                    totalSum += calculationResult;
                }
            }
        }
        if (totalSum % 10 != 0) {
            errors.add(PAYMENT_SYSTEM_ERROR_MESSAGE);
        }
        return errors;
    }
}

