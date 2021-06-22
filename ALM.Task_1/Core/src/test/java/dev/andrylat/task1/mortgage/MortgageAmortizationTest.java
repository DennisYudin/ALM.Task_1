package dev.andrylat.task1.mortgage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MortgageAmortizationTest {
    private Amortization mortgageAmortization = new MortgageAmortization();
    
    @Test
    void getInterest_ShouldCalculateInterest_WhenInputIsLoanAndAnnualInterest() {
        
        int principal = 100_000;
        float annualInterest = 6;
        
        double interest = mortgageAmortization.getInterest(principal, annualInterest);
        
        double actual = interest;
        double expected = 499.9999888241291;
        
        assertEquals(expected, actual);
    }
    
    @Test
    void calculatePrincipal_ShouldCalculatePrincipal_WhenInputIsLoanAnnualInterestAndPaymentInMonth() {
        
        int loan = 100_000;
        float annualInterest = 6;
        double paymentInMonth = 599.55;
        
        double principal = mortgageAmortization.calculatePrincipal(paymentInMonth, loan, annualInterest);
        
        double actual = principal;
        double expected = 99.55001117587085;
        
        assertEquals(expected, actual);
    }
    
    @Test
    void CalculateEndingBalance_ShouldCalculateEndingBalance_WhenInputIsLoanAnnualInterestAndPaymentInMonth() {
        
        int loan = 100_000;
        float annualInterest = 6;
        double paymentInMonth = 599.55;
        
        double endingBalance = mortgageAmortization.calculateEndingBalance(paymentInMonth, loan, annualInterest);
        
        double actual = endingBalance;
        double expected = 99900.44998882413;
        
        assertEquals(expected, actual);
    }
}

