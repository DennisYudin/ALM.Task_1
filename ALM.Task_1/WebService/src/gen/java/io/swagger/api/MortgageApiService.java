package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Amortization;
import io.swagger.model.Calculator;
import io.swagger.model.MortgageAmortizationResult;
import io.swagger.model.MortgageCaculatorResult;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-03T07:36:36.973Z[GMT]")public abstract class MortgageApiService {
    public abstract Response mortgageAmortizationPost(Amortization body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response mortgageCalculatorPost(Calculator body,SecurityContext securityContext) throws NotFoundException;
}
