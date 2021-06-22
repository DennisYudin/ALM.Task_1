package dev.andrylat.task1.payment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaymentSystemResolverTest {
    
    Resolver<PaymentSystem, String> paymentSystemResolver = new PaymentSystemResolver();
    
    @Test
    void checkCardNumber_ShouldReturnAmericanExpress_WhenInputIsCardNumber() {
        String cardNumber = "3451 7792 5488 3488";        
        PaymentSystem paymentSystem = paymentSystemResolver.resolve(cardNumber);
        
        String actual = paymentSystem.getName();
        String expected = "American express";
        
        assertEquals(expected, actual);
    }
    
    @Test
    void checkCardNumber_ShouldReturnJCB_WhenInputIsCardNumber() {
        String cardNumber = "3569 9900 1009 5841";
        PaymentSystem paymentSystem = paymentSystemResolver.resolve(cardNumber);
        
        String actual = paymentSystem.getName();
        String expected = "JCB";
        
        assertEquals(expected, actual);
    }
    
    @Test
    void checkCardNumber_ShouldReturnDinersClub_WhenInputIsCardNumber() {
        String cardNumber = "3657 4070 2667 6426";
        PaymentSystem paymentSystem = paymentSystemResolver.resolve(cardNumber);
        
        String actual = paymentSystem.getName();
        String expected = "Diners club";
        
        assertEquals(expected, actual);
    }
    
    @Test
    void checkCardNumber_ShouldReturnVisa_WhenInputIsCardNumber() {
        String cardNumber = "4035 5010 0000 0008";
        PaymentSystem paymentSystem = paymentSystemResolver.resolve(cardNumber);
        
        String actual = paymentSystem.getName();
        String expected = "Visa";
        
        assertEquals(expected, actual);
    }
    
    @Test
    void checkCardNumber_ShouldReturnMasterCard_WhenInputIsCardNumber() {
        String cardNumber = "5066 9911 1111 1118";
        PaymentSystem paymentSystem = paymentSystemResolver.resolve(cardNumber);
        
        String actual = paymentSystem.getName();
        String expected = "Mastercard";
        
        assertEquals(expected, actual);
    }
    
    @Test
    void checkCardNumber_ShouldReturnDiscover_WhenInputIsCardNumber() {
        String cardNumber = "6011 6011 6011 6611";
        PaymentSystem paymentSystem = paymentSystemResolver.resolve(cardNumber);
        
        String actual = paymentSystem.getName();
        String expected = "Discover";
        
        assertEquals(expected, actual);
    }    
    
    @Test
    void checkCardNumber_ShouldThrowIllegalArgumentException_WhenInputIs() {
        String cardNumber = "1234 1234 1234 1234";
        
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> paymentSystemResolver.resolve(cardNumber).name());

        String expected = "There is no such Payment System.";
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }
}

