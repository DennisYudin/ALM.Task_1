package dev.andrylat.task1.mortgage;


public class MortgageAmortization implements Amortization {
    private static final byte PERCENT = 100;
    private static final byte MONTHS_IN_YEAR = 12;
    
    @Override
    public double calculateEndingBalance(double paymentInMonth, double loan, float annualInterestRate) {
        
        double principal = calculatePrincipal(paymentInMonth, loan, annualInterestRate);
        
        double balance = loan - principal;
        
        return balance;
    }
    
    @Override
    public double calculatePrincipal(double paymentInMonth, double loan, float annualInterestRate) {
        
        double lenderMonthlyInterest = getInterest(loan, annualInterestRate);
        
        double principal = paymentInMonth - lenderMonthlyInterest;
        
        return principal;
    }
    
    @Override
    public double getInterest(double loan, float annualInterestRate) {
        
        float monthlyInterest = getMonthlyInterest(annualInterestRate);
        
        double lenderMonthlyInterest = loan * monthlyInterest;
        
        return lenderMonthlyInterest;
    }
    
    private float getMonthlyInterest(float annualInterestRate) {
        
        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        
        return monthlyInterest;
    }    
}

