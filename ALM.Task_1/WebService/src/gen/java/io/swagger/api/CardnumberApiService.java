package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.CardValidationRequest;
import io.swagger.model.CardValidationResponse;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T06:09:19.388Z[GMT]")public abstract class CardnumberApiService {
    public abstract Response cardnumberValidationPost(CardValidationRequest body,SecurityContext securityContext) throws NotFoundException;
}
