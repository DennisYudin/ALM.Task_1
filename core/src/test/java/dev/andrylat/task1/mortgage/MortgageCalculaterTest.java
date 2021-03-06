
package dev.andrylat.task1.mortgage;

import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;

import org.junit.jupiter.api.Test;

class MortgageCalculaterTest {
    private Loan mortgage = new MortgageCalculator();
    
//    @Test
//    void calculate_ShouldCalculateMonthlyMortgagePayment_WhenInputIsPrincipalAnnualInterestAndYears() {
//        
//        int principal = 100_000;
//        float annualInterest = 6;
//        byte years = 30;
//        
//        double monthlyPayment = mortgage.calculate(principal, annualInterest, years);
//        
//        String actual = NumberFormat.getCurrencyInstance().format(monthlyPayment);
//        String expected = "599,55 ₽";
//        
//        assertEquals(expected, actual);
//    }
    
//    @Test
//    void calculate_ShouldThrowException_WhenInputIsIncorrectPrincipal() {
//        
//        int principal = 0;
//        float annualInterest = 6;
//        byte years = 30;
//        
//        Throwable exception = assertThrows(IllegalArgumentException.class,
//                () -> mortgage.сalculate(principal, annualInterest, years));
//        
//        String expected = "You should enter a value between 1000.0 and 1.0E8";
//        String actual = exception.getMessage();
//        
//        assertEquals(expected, actual);
//    }
//    
//    @Test
//    void calculate_ShouldThrowException_WhenInputIsNegativePrincipal() {
//        
//        int principal = -100_000;
//        float annualInterest = 6;
//        byte years = 30;
//        
//        Throwable exception = assertThrows(IllegalArgumentException.class,
//                () -> mortgage.сalculate(principal, annualInterest, years));
//        
//        String expected = "You should enter a value between 1000.0 and 1.0E8";
//        String actual = exception.getMessage();
//        
//        assertEquals(expected, actual);
//    }
//    
//    @Test
//    void calculate_ShouldThrowException_WhenInputIsIncorrectAnnualInterest() {
//        
//        int principal = 100_000;
//        float annualInterest = 0;
//        byte years = 30;
//        
//        Throwable exception = assertThrows(IllegalArgumentException.class,
//                () -> mortgage.сalculate(principal, annualInterest, years));
//        
//        String expected = "You should enter a value between 1.0 and 30.0";
//        String actual = exception.getMessage();
//        
//        assertEquals(expected, actual);
//    }
//    
//    @Test
//    void calculate_ShouldThrowException_WhenInputIsIncorrectYears() {
//        
//        int principal = 100_000;
//        float annualInterest = 6;
//        byte years = 0;
//        
//        Throwable exception = assertThrows(IllegalArgumentException.class,
//                () -> mortgage.сalculate(principal, annualInterest, years));
//        
//        String expected = "You should enter a value between 1.0 and 30.0";
//        String actual = exception.getMessage();
//        
//        assertEquals(expected, actual);
//    }        
}

