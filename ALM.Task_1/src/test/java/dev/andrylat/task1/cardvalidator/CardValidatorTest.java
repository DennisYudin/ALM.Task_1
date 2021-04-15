package dev.andrylat.task1.cardvalidator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardValidatorTest {
    
    Validator cardValidator = new CardValidator();
    
    @Test
    void validate_ShouldReturnMessagesAboutInappropriateLengthAndUndefinedPaymentSystem_WhenInputIsCardNumberWithLessThen16Numbers() {
        String cardNumber = "1234 1234 1234 123";
        
        StringBuilder expected = new StringBuilder();
        
        expected.append("Card number is invalid.").append("\n");
        expected.append("Errors:").append("\n");
        expected.append("-> Length should be 16 symbols").append("\n");
        expected.append("-> Payment system can't be determine").append("\n");
        
        StringBuilder actual = cardValidator.checkCardNumber(cardNumber);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void validate_ShouldReturnMessagesAboutInappropriateLengthAndUndefinedPaymentSystem_WhenInputIsCardNumberWithMoreThen16Numbers() {
        String cardNumber = "1234 1234 1234 1234 1";
        
        StringBuilder expected = new StringBuilder();
        
        expected.append("Card number is invalid.").append("\n");
        expected.append("Errors:").append("\n");
        expected.append("-> Length should be 16 symbols").append("\n");
        expected.append("-> Payment system can't be determine").append("\n");
        
        StringBuilder actual = cardValidator.checkCardNumber(cardNumber);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void validate_ShouldReturnMessagesNumberShouldContainOnlyDigitsAndUndefinedPaymentSystem_WhenInputIsCardNumberIsSpecialSymbols() {
        String cardNumber = "%%%% #### @@@@ ****";
        
        StringBuilder expected = new StringBuilder();
        
        expected.append("Card number is invalid.").append("\n");
        expected.append("Errors:").append("\n");
        expected.append("-> Number should contain only digits").append("\n");
        expected.append("-> Payment system can't be determine").append("\n");
        
        StringBuilder actual = cardValidator.checkCardNumber(cardNumber);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void validate_ShouldReturnMessagesAboutLengthAndDigitsAndUndefinedPaymentSystem_WhenInputIsCardNumberOfRandomSetCharacters() {
        String cardNumber = "1234xzyq1111";
        
        StringBuilder expected = new StringBuilder();
        
        expected.append("Card number is invalid.").append("\n");
        expected.append("Errors:").append("\n");
        expected.append("-> Length should be 16 symbols").append("\n");
        expected.append("-> Number should contain only digits").append("\n");
        expected.append("-> Payment system can't be determine").append("\n");
        
        StringBuilder actual = cardValidator.checkCardNumber(cardNumber);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void validate_ShouldReturnMessageAboutUndefinedPaymentSystem_WhenInputIsNonExistCardNumber() {
        String cardNumber = "1569 9900 1009 5841";
        
        StringBuilder expected = new StringBuilder();
        
        expected.append("Card number is invalid.").append("\n");
        expected.append("Errors:").append("\n");
        expected.append("-> Payment system can't be determine").append("\n");
        
        StringBuilder actual = cardValidator.checkCardNumber(cardNumber);
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    void validate_ShouldReturnMessageAboutCardIsValid_WhenInputIsCorrectCardNumber() {
        String cardNumber = "3657 4070 2667 6426";
        
        StringBuilder expected = new StringBuilder();
        
        expected.append("Card is valid. Payment system is \"Diners club\".").append("\n");
        
        StringBuilder actual = cardValidator.checkCardNumber(cardNumber);
        
        assertEquals(expected.toString(), actual.toString());
    }
}

