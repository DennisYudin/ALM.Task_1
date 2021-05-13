package dev.andrylat.task1.mortgage;

public class MortgageCalculator implements Loan {    
    private static final byte PERCENT = 100;
    private static final byte MONTHS_IN_YEAR = 12;  
    
    @Override
    public double сalculate(int principal, float annualInterest, byte years) {
        
        float monthlyInterest = getMonthlyInterest(annualInterest);
        short numberOfPayment = getNumberOfPayments(years);
        
        double dividend = (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment));
        double divisor = (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);
                
        double monthlyPayment = principal * dividend / divisor;        
        
        return monthlyPayment;
    }
    
    private float getMonthlyInterest(float annualInterestRate) {

        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        
        return monthlyInterest;
    }
    
    private short getNumberOfPayments(short amountYears) {        
        
        short numberOfPayments = (short) (amountYears * MONTHS_IN_YEAR);
        
        return numberOfPayments;
    }
}

