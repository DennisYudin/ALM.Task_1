package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.CardValidationRequest;
import io.swagger.model.CardValidationResponse;

import java.util.Map;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T06:09:19.388Z[GMT]")
public class CardnumberApiServiceImpl extends CardnumberApiService {
    @Override
    public Response cardnumberValidationPost(CardValidationRequest body, SecurityContext securityContext)
            throws NotFoundException {
        Validator cardValidator = new CardValidator();
        
        String cardNumber = body.getCardNumber();
        
        List<String> errors = cardValidator.validate(cardNumber);
        
        if (errors.isEmpty()) {
            CardValidationResponse successfulResponse = createSuccessfulResponse(cardNumber);
            
            return Response.ok(successfulResponse.toString()).build();
        } else {
            CardValidationResponse unsuccessfulResponse = createUnsuccessfulResponse(errors);
            
            return Response.ok(unsuccessfulResponse.toString()).build();
        }
    }
    
    private CardValidationResponse createSuccessfulResponse(String input) {
        Resolver<PaymentSystem, String> paymentSystemResolver = new PaymentSystemResolver();
        CardValidationResponse cardValidationResponse = new CardValidationResponse();
        
        PaymentSystem paymentSystem = paymentSystemResolver.resolve(input);
        String paymentSystemName = paymentSystem.getName();
        
        cardValidationResponse.setProcessingResult(true);
        cardValidationResponse.setErrorMessages(null);
        cardValidationResponse.setValidationSystemName(paymentSystemName);
        
        return cardValidationResponse;
    }
    
    private CardValidationResponse createUnsuccessfulResponse(List<String> messages) {
        CardValidationResponse cardValidationResponse = new CardValidationResponse();
        
        cardValidationResponse.setProcessingResult(false);
        cardValidationResponse.setErrorMessages(messages);
        cardValidationResponse.setValidationSystemName(null);
        
        return cardValidationResponse;
    }
}
