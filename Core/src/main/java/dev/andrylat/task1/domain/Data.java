package dev.andrylat.task1.domain;

public class Data {
    
    private double paymentInMonth;
    private double loan;
    private float annualInterestRate;
    private byte amountYears;
    
    public double getPaymentInMonth() {
        return paymentInMonth;
    }
    
    public double getLoan() {
        return loan;
    }
    
    public float getAnnualInterestRate() {
        return annualInterestRate;
    }
    
    public byte getAmountYears() {
        return amountYears;
    }
    
    public Data(double paymentInMonth, double loan, float annualInterestRate, byte amountYears) {
        this.paymentInMonth = paymentInMonth;
        this.loan = loan;
        this.annualInterestRate = annualInterestRate;
        this.amountYears = amountYears;
    }    
}

