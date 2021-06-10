package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.AmortizationRequest;
import io.swagger.model.CalculatorRequest;
import io.swagger.model.MortgageAmortizationResponse;
import io.swagger.model.MortgageCaculatorResponse;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import dev.andrylat.task1.mortgage.Amortization;
import dev.andrylat.task1.mortgage.Loan;
import dev.andrylat.task1.mortgage.MortgageAmortization;
import dev.andrylat.task1.mortgage.MortgageCalculator;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T06:09:19.388Z[GMT]")
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
    public Response mortgageAmortizationPost(AmortizationRequest body, SecurityContext securityContext)
            throws NotFoundException {
        Loan mortgage = new MortgageCalculator();       
        
        int loan = body.getPrincipal();
        float annualInterest = body.getAnnualInterest();
        byte years = body.getPeriod();
        
        List<String> errorMessages = validateInput(loan, annualInterest, years);
        
        if (errorMessages.isEmpty()) {
            double monthlyPayment = mortgage.calculate(loan, annualInterest, years);
            double loanFormatted = loan;
            
            List<MortgageAmortizationResponseMortgageamortization> amortizationData = calculateAmortization(
                    loanFormatted, annualInterest, years, monthlyPayment);
            
            MortgageAmortizationResponse successfulResponse = createValidResponse(amortizationData);
            
            return Response.ok(successfulResponse.toString()).build();
        } else {
            MortgageAmortizationResponse unsuccessfulResponse = createInvalidResponse(errorMessages);
            
            return Response.ok(unsuccessfulResponse.toString()).build();
        }
    }
    
    private MortgageAmortizationResponse createValidResponse(List<MortgageAmortizationResponseMortgageamortization> input) {
        MortgageAmortizationResponse mortgageAmortizationResponse = new MortgageAmortizationResponse();
        
        mortgageAmortizationResponse.setProcessingResult(true);
        mortgageAmortizationResponse.setErrorMessages(null);
        mortgageAmortizationResponse.setMortgageAmortization(input);
        
        return mortgageAmortizationResponse;
    }
    
    private MortgageAmortizationResponse createInvalidResponse(List<String> messages) {
        MortgageAmortizationResponse mortgageAmortizationResponse = new MortgageAmortizationResponse();
        
        mortgageAmortizationResponse.setProcessingResult(false);
        mortgageAmortizationResponse.setErrorMessages(messages);
        mortgageAmortizationResponse.setMortgageAmortization(null);
        
        return mortgageAmortizationResponse;
    }
    
    private List<MortgageAmortizationResponseMortgageamortization> calculateAmortization(double credit, float rate,
            byte paymentTerm, double payment) {
        List<MortgageAmortizationResponseMortgageamortization> list = new ArrayList<>();
        Amortization mortgageAmortization = new MortgageAmortization();
        
        for (short month = 1; month <= paymentTerm * MONTHS_IN_YEAR; month++) {
            MortgageAmortizationResponseMortgageamortization amortization = new MortgageAmortizationResponseMortgageamortization();
            
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
    public Response mortgageCalculatorPost(CalculatorRequest body, SecurityContext securityContext)
            throws NotFoundException {
        Loan mortgage = new MortgageCalculator();
        
        int principal = body.getPrincipal();
        float annualInterest = body.getAnnualInterest();
        byte years = body.getPeriod();
        
        List<String> errorMessages = validateInput(principal, annualInterest, years);
        
        if (errorMessages.isEmpty()) {
            double monthlyPayment = mortgage.calculate(principal, annualInterest, years);
            double monthlyPaymentRounded = roundDoubleValue(monthlyPayment);
            
            MortgageCaculatorResponse successfulResponse = createSuccessfulResponse(monthlyPaymentRounded);
            
            return Response.ok(successfulResponse.toString()).build();
        } else {
            MortgageCaculatorResponse unsuccessfulResponse = createUnsuccessfulResponse(errorMessages);
            
            return Response.ok(unsuccessfulResponse.toString()).build();
        }
    }
    
    private MortgageCaculatorResponse createSuccessfulResponse(double payment) {
        MortgageCaculatorResponse mortgageCaculatorResponse = new MortgageCaculatorResponse();
        
        mortgageCaculatorResponse.setProcessingResult(true);
        mortgageCaculatorResponse.setErrorMessages(null);
        mortgageCaculatorResponse.setMonthlyPayment(payment);
        
        return mortgageCaculatorResponse;
    }
    
    private MortgageCaculatorResponse createUnsuccessfulResponse(List<String> messages) {
        MortgageCaculatorResponse mortgageCaculatorResponse = new MortgageCaculatorResponse();
        
        mortgageCaculatorResponse.setProcessingResult(false);
        mortgageCaculatorResponse.setErrorMessages(messages);
        mortgageCaculatorResponse.setMonthlyPayment(null);
        
        return mortgageCaculatorResponse;
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

