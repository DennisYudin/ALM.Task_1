package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.MortgageApiService;
import io.swagger.api.factories.MortgageApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.AmortizationRequest;
import io.swagger.model.CalculatorRequest;
import io.swagger.model.MortgageAmortizationResponse;
import io.swagger.model.MortgageCaculatorResponse;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;


@Path("/mortgage")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T06:09:19.388Z[GMT]")public class MortgageApi  {
   private final MortgageApiService delegate;

   public MortgageApi(@Context ServletConfig servletContext) {
      MortgageApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("MortgageApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (MortgageApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = MortgageApiServiceFactory.getMortgageApi();
      }

      this.delegate = delegate;
   }

    @POST
    @Path("/amortization")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "", description = "", tags={ "Amortization" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful response", content = @Content(schema = @Schema(implementation = MortgageAmortizationResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Unsuccessful response", content = @Content(schema = @Schema(implementation = MortgageAmortizationResponse.class))) })
    public Response mortgageAmortizationPost(@Parameter(in = ParameterIn.DEFAULT, description = "Calculate mortgage amortization. User **must** enter principal from 1K up to 100M, annual interest rate from 1 up to 30 percent and period in years from 1 up to 30." ) AmortizationRequest body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.mortgageAmortizationPost(body,securityContext);
    }
    @POST
    @Path("/calculator")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "", description = "", tags={ "Mortgage" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful response", content = @Content(schema = @Schema(implementation = MortgageCaculatorResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Unsuccessful response", content = @Content(schema = @Schema(implementation = MortgageCaculatorResponse.class))) })
    public Response mortgageCalculatorPost(@Parameter(in = ParameterIn.DEFAULT, description = "Calculate monthly mortgage payment. User **must** enter principal from 1K up to 100M, annual interest rate from 1 up to 30 percent and period in years from 1 up to 30." ) CalculatorRequest body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.mortgageCalculatorPost(body,securityContext);
    }
}
