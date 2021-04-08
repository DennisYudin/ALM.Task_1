package dev.andrylat.task1.cardvalidator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardValidatorTest {
    
    Validator cardValidator = new CardValidator();
    
    @Test
    void validate_ShouldReturnMessagesAboutInappropriateLengthAndUndefinedPaymentSystem_WhenInputIsCardNumberWithLessThen16Numbers() {
        String cardNumber = "1234 1234 1234 123";
        
        cardValidator.validate(cardNumber);
        
        String expected = "[Length should be 16 symbols, Payment system can't be determine]";
        String actual = cardValidator.validate(cardNumber).toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    void validate_ShouldReturnMessagesAboutInappropriateLengthAndUndefinedPaymentSystem_WhenInputIsCardNumberWithMoreThen16Numbers() {
        String cardNumber = "1234 1234 1234 1234 1";
        
        cardValidator.validate(cardNumber);
        
        String expected = "[Length should be 16 symbols, Payment system can't be determine]";
        String actual = cardValidator.validate(cardNumber).toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    void validate_ShouldReturnMessagesNumberShouldContainOnlyDigitsAndUndefinedPaymentSystem_WhenInputIsCardNumberIsSpecialSymbols() {
        String cardNumber = "%%%% #### @@@@ ****";
        
        cardValidator.validate(cardNumber);
        
        String expected = "[Number should contain only digits, Payment system can't be determine]";
        String actual = cardValidator.validate(cardNumber).toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    void validate_ShouldReturnMessagesAboutLengthAndDigitsAndUndefinedPaymentSystem_WhenInputIsCardNumberOfRandomSetCharacters() {
        String cardNumber = "1234xzyq1111";
        
        cardValidator.validate(cardNumber);
        
        String expected = "[Length should be 16 symbols, Number should contain only digits, Payment system can't be determine]";
        String actual = cardValidator.validate(cardNumber).toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    void validate_ShouldReturnMessageAboutUndefinedPaymentSystem_WhenInputIsNonExistCardNumber() {
        String cardNumber = "1569 9900 1009 5841";
        
        cardValidator.validate(cardNumber);
        
        String expected = "[Payment system can't be determine]";
        String actual = cardValidator.validate(cardNumber).toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    void validate_ShouldReturnEmptyList_WhenInputIsCorrectCardNumber() {
        String cardNumber = "3657 4070 2667 6426";
        
        cardValidator.validate(cardNumber);
        
        String expected = "[]";
        String actual = cardValidator.validate(cardNumber).toString();
        
        assertEquals(expected, actual);
    }
}

