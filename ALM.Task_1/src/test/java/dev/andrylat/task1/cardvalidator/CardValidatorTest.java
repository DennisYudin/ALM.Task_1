package dev.andrylat.task1.cardvalidator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CardValidatorTest {
    
    Validator cardValidator = new CardValidator();
    
    @Test
    void validate_ShouldReturnMessagesAboutInappropriateLengthAndUndefinedPaymentSystem_WhenInputIsCardNumberWithLessThen16Numbers() {
        String cardNumber = "1234 1234 1234 123";
        
        List<String> expected = new ArrayList<>();
        
        expected.add("Length should be 16 symbols");
        expected.add("Payment system can't be determine");
        
        List<String> actual = cardValidator.validate(cardNumber);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void validate_ShouldReturnMessagesAboutInappropriateLengthAndUndefinedPaymentSystem_WhenInputIsCardNumberWithMoreThen16Numbers() {
        String cardNumber = "1234 1234 1234 1234 1";
        
        List<String> expected = new ArrayList<>();
        
        expected.add("Length should be 16 symbols");
        expected.add("Payment system can't be determine");
        
        List<String> actual = cardValidator.validate(cardNumber);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void validate_ShouldReturnMessagesNumberShouldContainOnlyDigitsAndUndefinedPaymentSystem_WhenInputIsCardNumberIsSpecialSymbols() {
        String cardNumber = "%%%% #### @@@@ ****";
        
        List<String> expected = new ArrayList<>();
        
        expected.add("Number should contain only digits");
        expected.add("Payment system can't be determine");
        
        List<String> actual = cardValidator.validate(cardNumber);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void validate_ShouldReturnMessagesAboutLengthAndDigitsAndUndefinedPaymentSystem_WhenInputIsCardNumberOfRandomSetCharacters() {
        String cardNumber = "1234xzyq1111";
        
        List<String> expected = new ArrayList<>();
        
        expected.add("Length should be 16 symbols");
        expected.add("Number should contain only digits");
        expected.add("Payment system can't be determine");
        
        List<String> actual = cardValidator.validate(cardNumber);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void validate_ShouldReturnMessageAboutUndefinedPaymentSystem_WhenInputIsNonExistCardNumber() {
        String cardNumber = "1569 9900 1009 5841";
        
        List<String> expected = new ArrayList<>();
        
        expected.add("Payment system can't be determine");

        List<String> actual = cardValidator.validate(cardNumber);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void validate_ShouldReturnEmptyList_WhenInputIsCorrectCardNumber() {
        String cardNumber = "3657 4070 2667 6426";
        
        List<String> actual = cardValidator.validate(cardNumber);
        
        assertTrue(actual.isEmpty());
    }
}

