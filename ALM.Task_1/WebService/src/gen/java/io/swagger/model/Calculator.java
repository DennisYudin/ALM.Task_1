/*
 * ALM.Task_1 API
 * # Curret application check ***card number*** and calculate ***mortgage***
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Calculator
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-08T11:35:37.684Z[GMT]")public class Calculator   {
  @JsonProperty("principal")
  private Integer principal = null;

  @JsonProperty("annual-interest")
  private Float annualInterest = null;

  @JsonProperty("period")
  private Byte period = null;

  public Calculator principal(Integer principal) {
    this.principal = principal;
    return this;
  }

  /**
   * Get principal
   * @return principal
   **/
  @JsonProperty("principal")
  @Schema(description = "")
  public Integer getPrincipal() {
    return principal;
  }

  public void setPrincipal(Integer principal) {
    this.principal = principal;
  }

  public Calculator annualInterest(Float annualInterest) {
    this.annualInterest = annualInterest;
    return this;
  }

  /**
   * Get annualInterest
   * @return annualInterest
   **/
  @JsonProperty("annual-interest")
  @Schema(description = "")
  public Float getAnnualInterest() {
    return annualInterest;
  }

  public void setAnnualInterest(Float annualInterest) {
    this.annualInterest = annualInterest;
  }

  public Calculator period(Byte period) {
    this.period = period;
    return this;
  }

  /**
   * Get period
   * @return period
   **/
  @JsonProperty("period")
  @Schema(description = "")
  @Valid
  public Byte getPeriod() {
    return period;
  }

  public void setPeriod(Byte period) {
    this.period = period;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Calculator calculator = (Calculator) o;
    return Objects.equals(this.principal, calculator.principal) &&
        Objects.equals(this.annualInterest, calculator.annualInterest) &&
        Objects.equals(this.period, calculator.period);
  }

  @Override
  public int hashCode() {
    return Objects.hash(principal, annualInterest, period);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Calculator {\n");
    
    sb.append("    principal: ").append(toIndentedString(principal)).append("\n");
    sb.append("    annual-interest: ").append(toIndentedString(annualInterest)).append("\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
