package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.CardValidation;
import io.swagger.model.CardValidationResult;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import dev.andrylat.task1.cardvalidator.CardValidator;
import dev.andrylat.task1.cardvalidator.Validator;
import dev.andrylat.task1.payment.PaymentSystem;
import dev.andrylat.task1.payment.PaymentSystemResolver;
import dev.andrylat.task1.payment.Resolver;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-03T07:36:36.973Z[GMT]")public class CardnumberApiServiceImpl extends CardnumberApiService {
    @Override
    public Response cardnumberValidationPost(CardValidation body, SecurityContext securityContext) throws NotFoundException {         
        Validator cardValidator = new CardValidator();
        Resolver<PaymentSystem, String> paymentSystemResolver = new PaymentSystemResolver();
        CardValidationResult cardValidationResult = new CardValidationResult();
        
        String cardNumber = body.getCardNumber();
         
        List<String> errors = cardValidator.validate(cardNumber);                
        
        if (errors.isEmpty()) {
            cardValidationResult.setProcessingResult(true);
            
            PaymentSystem paymentSystem = paymentSystemResolver.resolve(cardNumber);
            String paymentSystemName = paymentSystem.getName();
            
            cardValidationResult.setErrorMessages(null);
            cardValidationResult.setValidationSystemName(paymentSystemName);            
        } else {
            cardValidationResult.setProcessingResult(false);
            cardValidationResult.setErrorMessages(errors);
            cardValidationResult.setValidationSystemName(null);
        }                
        return Response.ok(cardValidationResult.toString()).build();
    }
}


