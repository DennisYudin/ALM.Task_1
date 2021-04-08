package dev.andrylat.task1.payment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaymentSystemIdentifierTest {
    
    Resolver paymentSystemIdentifier = new PaymentSystemIdentifier();
    
    @Test
    void checkCardNumber_ShouldReturnAmericanExpress_WhenInputIsCardNumber() {
        String cardNumber = "3451 7792 5488 3488";        
        PaymentSystem paymentSystem = paymentSystemIdentifier.determinePaymentSystem(cardNumber);
        
        String actual = paymentSystem.getPaymentSystemData().get(0);
        String expected = "American express";
        
        assertEquals(expected, actual);
    }
    
    @Test
    void checkCardNumber_ShouldReturnJCB_WhenInputIsCardNumber() {
        String cardNumber = "3569 9900 1009 5841";
        PaymentSystem paymentSystem = paymentSystemIdentifier.determinePaymentSystem(cardNumber);
        
        String actual = paymentSystem.getPaymentSystemData().get(0);
        String expected = "JCB";
        
        assertEquals(expected, actual);
    }
    
    @Test
    void checkCardNumber_ShouldReturnDinersClub_WhenInputIsCardNumber() {
        String cardNumber = "3657 4070 2667 6426";
        PaymentSystem paymentSystem = paymentSystemIdentifier.determinePaymentSystem(cardNumber);
        
        String actual = paymentSystem.getPaymentSystemData().get(0);
        String expected = "Diners club";
        
        assertEquals(expected, actual);
    }
    
    @Test
    void checkCardNumber_ShouldReturnVisa_WhenInputIsCardNumber() {
        String cardNumber = "4035 5010 0000 0008";
        PaymentSystem paymentSystem = paymentSystemIdentifier.determinePaymentSystem(cardNumber);
        
        String actual = paymentSystem.getPaymentSystemData().get(0);
        String expected = "Visa";
        
        assertEquals(expected, actual);
    }
    
    @Test
    void checkCardNumber_ShouldReturnMasterCard_WhenInputIsCardNumber() {
        String cardNumber = "5066 9911 1111 1118";
        PaymentSystem paymentSystem = paymentSystemIdentifier.determinePaymentSystem(cardNumber);
        
        String actual = paymentSystem.getPaymentSystemData().get(0);
        String expected = "Mastercard";
        
        assertEquals(expected, actual);
    }
    
    @Test
    void checkCardNumber_ShouldReturnDiscover_WhenInputIsCardNumber() {
        String cardNumber = "6011 6011 6011 6611";
        PaymentSystem paymentSystem = paymentSystemIdentifier.determinePaymentSystem(cardNumber);
        
        String actual = paymentSystem.getPaymentSystemData().get(0);
        String expected = "Discover";
        
        assertEquals(expected, actual);
    }    
    
    @Test
    void checkCardNumber_ShouldThrowIllegalArgumentException_WhenInputIs() {
        String cardNumber = "1234 1234 1234 1234";
        
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> paymentSystemIdentifier.determinePaymentSystem(cardNumber).name());

        String expected = "Value is null";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }
}

