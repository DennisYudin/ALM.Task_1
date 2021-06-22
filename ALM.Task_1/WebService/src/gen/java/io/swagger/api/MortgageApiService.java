package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.AmortizationRequest;
import io.swagger.model.CalculatorRequest;
import io.swagger.model.MortgageAmortizationResponse;
import io.swagger.model.MortgageCaculatorResponse;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T06:09:19.388Z[GMT]")public abstract class MortgageApiService {
    public abstract Response mortgageAmortizationPost(AmortizationRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response mortgageCalculatorPost(CalculatorRequest body,SecurityContext securityContext) throws NotFoundException;
}
