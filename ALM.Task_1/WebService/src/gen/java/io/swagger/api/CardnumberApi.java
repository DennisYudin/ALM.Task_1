package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.CardnumberApiService;
import io.swagger.api.factories.CardnumberApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.CardValidationRequest;
import io.swagger.model.CardValidationResponse;

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


@Path("/cardnumber")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T06:09:19.388Z[GMT]")public class CardnumberApi  {
   private final CardnumberApiService delegate;

   public CardnumberApi(@Context ServletConfig servletContext) {
      CardnumberApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("CardnumberApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (CardnumberApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = CardnumberApiServiceFactory.getCardnumberApi();
      }

      this.delegate = delegate;
   }

    @POST
    @Path("/validation")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "", description = "", tags={ "Card validation" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Valid", content = @Content(schema = @Schema(implementation = CardValidationResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid", content = @Content(schema = @Schema(implementation = CardValidationResponse.class))) })
    public Response cardnumberValidationPost(@Parameter(in = ParameterIn.DEFAULT, description = "Check card number and determine payment system. User **must** enter card number which consist is 16 digits. Allowed to enter card number with spaces between each four digits." ) CardValidationRequest body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.cardnumberValidationPost(body,securityContext);
    }
}
