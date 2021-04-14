package dev.andrylat.task1.mortgage;


public class MortgageCalculater implements Mortgage {    
    private static final byte PERCENT = 100;
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte MIN_VALUE = 1;
    private static final byte MAX_VALUE = 30;
    private static final int MIN_PRINCIPAL_VALUE = 1_000;
    private static final int MAX_PRINCIPAL_VALUE = 100_000_000;    
    
    @Override
    public double сalculate(int principal, float annualInterest, byte years) {
        validate(principal, MIN_PRINCIPAL_VALUE, MAX_PRINCIPAL_VALUE);
        
        float monthlyInterest = getMonthlyInterest(annualInterest);
        short numberOfPayment = getNumberOfPayments(years);
        
        double monthlyPayment = principal 
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment))
                / (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);        
        
        return monthlyPayment;
    }
    
    private float getMonthlyInterest(float annualInterestRate) {
        validate(annualInterestRate, MIN_VALUE, MAX_VALUE);

        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        
        return monthlyInterest;
    }
    
    private short getNumberOfPayments(short amountYears) {        
        validate(amountYears, MIN_VALUE, MAX_VALUE);
        
        short numberOfPayments = (short) (amountYears * MONTHS_IN_YEAR);
        
        return numberOfPayments;
    }
    
    private void validate(float input, double min, double max) {
        if (input < min || input > max) {
            throw new IllegalArgumentException("Enter a value between " + min + " and " + max);
        }
    }
}

