package io.swagger.api.factories;

import io.swagger.api.MortgageApiService;
import io.swagger.api.impl.MortgageApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-03T07:36:36.973Z[GMT]")public class MortgageApiServiceFactory {
    private final static MortgageApiService service = new MortgageApiServiceImpl();

    public static MortgageApiService getMortgageApi() {
        return service;
    }
}
