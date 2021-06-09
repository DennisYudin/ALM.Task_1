package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Amortization;
import io.swagger.model.Calculator;
import io.swagger.model.MortgageAmortizationResult;
import io.swagger.model.MortgageCaculatorResult;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import dev.andrylat.task1.domain.Data;
import dev.andrylat.task1.mortgage.Loan;
import dev.andrylat.task1.mortgage.MortgageAmortization;
import dev.andrylat.task1.mortgage.MortgageAmortizationTable;
import dev.andrylat.task1.mortgage.MortgageCalculator;
import dev.andrylat.task1.mortgage.Table;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-03T07:36:36.973Z[GMT]")
public class MortgageApiServiceImpl extends MortgageApiService {
    private static final byte MIN_ALLOWED_VALUE = 1;
    private static final byte MAX_ALLOWED_VALUE = 30;
    private static final int MIN_PRINCIPAL_VALUE = 1_000;
    private static final int MAX_PRINCIPAL_VALUE = 100_000_000;
    private static final String PRINCIPAL_ERROR_MESSAGE = "You should enter a value between " + MIN_PRINCIPAL_VALUE
            + " and " + MAX_PRINCIPAL_VALUE;
    private static final String ANNUAL_ERROR_MESSAGE = "You should enter a value between " + MIN_ALLOWED_VALUE + " and "
            + MAX_ALLOWED_VALUE;
    private static final String PERIOD_ERROR_MESSAGE = "You should enter a value between " + MIN_ALLOWED_VALUE + " and "
            + MAX_ALLOWED_VALUE;
    private static final int MONTHS_IN_YEAR = 12;
    
    @Override
    public Response mortgageAmortizationPost(Amortization body, SecurityContext securityContext)
            throws NotFoundException {
        Loan mortgage = new MortgageCalculator();
        MortgageAmortizationResult mortgageAmortizationResult = new MortgageAmortizationResult();        
        
        int loan = body.getPrincipal();
        float annualInterest = body.getAnnualInterest();
        byte years = body.getPeriod();
        
        List<String> errorMessages = validateInput(loan, annualInterest, years);
        
        if (errorMessages.isEmpty()) {
            double monthlyPayment = mortgage.calculate(loan, annualInterest, years);
            double principalFormatted = loan;
            
            List<MortgageAmortizationResultMortgageamortization> amortizationTable = calculateAmortization(
                    principalFormatted, annualInterest, years, monthlyPayment);
            
            mortgageAmortizationResult.setProcessingResult(true);
            mortgageAmortizationResult.setErrorMessages(null);
            mortgageAmortizationResult.setMortgageAmortization(amortizationTable);
            
            return Response.ok(mortgageAmortizationResult.toString()).build();
        } else {
            mortgageAmortizationResult.setProcessingResult(false);
            mortgageAmortizationResult.setErrorMessages(errorMessages);
            mortgageAmortizationResult.setMortgageAmortization(null);
            
            return Response.ok(mortgageAmortizationResult.toString()).build();
        }
    }
    
    private List<MortgageAmortizationResultMortgageamortization> calculateAmortization(double credit, float rate,
            byte paymentTerm, double payment) {
        List<MortgageAmortizationResultMortgageamortization> list = new ArrayList<>();
        MortgageAmortization mortgageAmortization = new MortgageAmortization();
        
        for (short month = 1; month <= paymentTerm * MONTHS_IN_YEAR; month++) {
            MortgageAmortizationResultMortgageamortization amortization = new MortgageAmortizationResultMortgageamortization();
            
            double interest = mortgageAmortization.getInterest(credit, rate);
            double principal = mortgageAmortization.calculatePrincipal(payment, credit, rate);
            double endingBalance = mortgageAmortization.calculateEndingBalance(payment, credit, rate);
            
            amortization.setMonth((int) month);
            
            double principalFormattedRounded = roundDoubleValue(credit);
            amortization.setStartingBalance(principalFormattedRounded);
            
            double monthlyPaymentRounded = roundDoubleValue(payment);
            amortization.setMonthlyPayment(monthlyPaymentRounded);
            
            double interestRounded = roundDoubleValue(interest);
            amortization.setInterest(interestRounded);
            
            double principalRounded = roundDoubleValue(principal);
            amortization.setPrincipal(principalRounded);
            
            if (endingBalance < 0) {
                endingBalance = 0;
            }
            
            double endingBalanceRounded = roundDoubleValue(endingBalance);
            amortization.setEndingBalance(endingBalanceRounded);
            
            list.add(amortization);
            
            credit = endingBalance;
        }
        return list;
    }
    
    @Override
    public Response mortgageCalculatorPost(Calculator body, SecurityContext securityContext) throws NotFoundException {
        Loan mortgage = new MortgageCalculator();
        MortgageCaculatorResult mortgageCaculatorResult = new MortgageCaculatorResult();
        
        int principal = body.getPrincipal();
        float annualInterest = body.getAnnualInterest();
        byte years = body.getPeriod();
        
        List<String> errorMessages = validateInput(principal, annualInterest, years);
        
        if (errorMessages.isEmpty()) {
            double monthlyPayment = mortgage.calculate(principal, annualInterest, years);
            double monthlyPaymentRounded = roundDoubleValue(monthlyPayment);
            
            mortgageCaculatorResult.setProcessingResult(true);
            mortgageCaculatorResult.setErrorMessages(null);
            mortgageCaculatorResult.setMonthlyPayment(monthlyPaymentRounded);
            
            return Response.ok(mortgageCaculatorResult.toString()).build();
        } else {
            mortgageCaculatorResult.setProcessingResult(false);
            mortgageCaculatorResult.setErrorMessages(errorMessages);
            mortgageCaculatorResult.setMonthlyPayment(null);
            
            return Response.ok(mortgageCaculatorResult.toString()).build();
        }
    }
    
    private List<String> validateInput(int loan, float interest, byte period) {
        List<String> errors = new ArrayList<>();
        
        if (loan < MIN_PRINCIPAL_VALUE || loan > MAX_PRINCIPAL_VALUE) {
            errors.add(PRINCIPAL_ERROR_MESSAGE);
        } else if (interest < MIN_ALLOWED_VALUE || interest > MAX_ALLOWED_VALUE) {
            errors.add(ANNUAL_ERROR_MESSAGE);
        } else if (period < MIN_ALLOWED_VALUE || period > MAX_ALLOWED_VALUE) {
            errors.add(PERIOD_ERROR_MESSAGE);
        }
        return errors;
    }
    
    private double roundDoubleValue(double input) {
        
        double inputRounded = Math.round(input * 100.0) / 100.0;
        
        return inputRounded;
    }
}
