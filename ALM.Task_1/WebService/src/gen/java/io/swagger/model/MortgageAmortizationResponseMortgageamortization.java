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
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * MortgageAmortizationResponseMortgageamortization
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T06:09:19.388Z[GMT]")public class MortgageAmortizationResponseMortgageamortization   {
  @JsonProperty("month")
  private Integer month = null;

  @JsonProperty("starting-balance")
  private Double startingBalance = null;

  @JsonProperty("monthly-payment")
  private Double monthlyPayment = null;

  @JsonProperty("interest")
  private Double interest = null;

  @JsonProperty("principal")
  private Double principal = null;

  @JsonProperty("ending-balance")
  private Double endingBalance = null;

  public MortgageAmortizationResponseMortgageamortization month(Integer month) {
    this.month = month;
    return this;
  }

  /**
   * Get month
   * @return month
   **/
  @JsonProperty("month")
  @Schema(description = "")
  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public MortgageAmortizationResponseMortgageamortization startingBalance(Double startingBalance) {
    this.startingBalance = startingBalance;
    return this;
  }

  /**
   * Get startingBalance
   * @return startingBalance
   **/
  @JsonProperty("starting-balance")
  @Schema(description = "")
  public Double getStartingBalance() {
    return startingBalance;
  }

  public void setStartingBalance(Double startingBalance) {
    this.startingBalance = startingBalance;
  }

  public MortgageAmortizationResponseMortgageamortization monthlyPayment(Double monthlyPayment) {
    this.monthlyPayment = monthlyPayment;
    return this;
  }

  /**
   * Get monthlyPayment
   * @return monthlyPayment
   **/
  @JsonProperty("monthly-payment")
  @Schema(description = "")
  public Double getMonthlyPayment() {
    return monthlyPayment;
  }

  public void setMonthlyPayment(Double monthlyPayment) {
    this.monthlyPayment = monthlyPayment;
  }

  public MortgageAmortizationResponseMortgageamortization interest(Double interest) {
    this.interest = interest;
    return this;
  }

  /**
   * Get interest
   * @return interest
   **/
  @JsonProperty("interest")
  @Schema(description = "")
  public Double getInterest() {
    return interest;
  }

  public void setInterest(Double interest) {
    this.interest = interest;
  }

  public MortgageAmortizationResponseMortgageamortization principal(Double principal) {
    this.principal = principal;
    return this;
  }

  /**
   * Get principal
   * @return principal
   **/
  @JsonProperty("principal")
  @Schema(description = "")
  public Double getPrincipal() {
    return principal;
  }

  public void setPrincipal(Double principal) {
    this.principal = principal;
  }

  public MortgageAmortizationResponseMortgageamortization endingBalance(Double endingBalance) {
    this.endingBalance = endingBalance;
    return this;
  }

  /**
   * Get endingBalance
   * @return endingBalance
   **/
  @JsonProperty("ending-balance")
  @Schema(description = "")
  public Double getEndingBalance() {
    return endingBalance;
  }

  public void setEndingBalance(Double endingBalance) {
    this.endingBalance = endingBalance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MortgageAmortizationResponseMortgageamortization mortgageAmortizationResponseMortgageamortization = (MortgageAmortizationResponseMortgageamortization) o;
    return Objects.equals(this.month, mortgageAmortizationResponseMortgageamortization.month) &&
        Objects.equals(this.startingBalance, mortgageAmortizationResponseMortgageamortization.startingBalance) &&
        Objects.equals(this.monthlyPayment, mortgageAmortizationResponseMortgageamortization.monthlyPayment) &&
        Objects.equals(this.interest, mortgageAmortizationResponseMortgageamortization.interest) &&
        Objects.equals(this.principal, mortgageAmortizationResponseMortgageamortization.principal) &&
        Objects.equals(this.endingBalance, mortgageAmortizationResponseMortgageamortization.endingBalance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(month, startingBalance, monthlyPayment, interest, principal, endingBalance);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    starting-balance: ").append(toIndentedString(startingBalance)).append("\n");
    sb.append("    monthly-payment: ").append(toIndentedString(monthlyPayment)).append("\n");
    sb.append("    interest: ").append(toIndentedString(interest)).append("\n");
    sb.append("    principal: ").append(toIndentedString(principal)).append("\n");
    sb.append("    ending-balance: ").append(toIndentedString(endingBalance)).append("\n");
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
