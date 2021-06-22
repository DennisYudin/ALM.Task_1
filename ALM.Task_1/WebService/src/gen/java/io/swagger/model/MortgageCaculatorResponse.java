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
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * MortgageCaculatorResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-10T06:09:19.388Z[GMT]")public class MortgageCaculatorResponse   {
  @JsonProperty("processing-result")
  private Boolean processingResult = null;

  @JsonProperty("error-messages")
  private List<String> errorMessages = null;

  @JsonProperty("monthly-payment")
  private Double monthlyPayment = null;

  public MortgageCaculatorResponse processingResult(Boolean processingResult) {
    this.processingResult = processingResult;
    return this;
  }

  /**
   * Get processingResult
   * @return processingResult
   **/
  @JsonProperty("processing-result")
  @Schema(description = "")
  public Boolean isProcessingResult() {
    return processingResult;
  }

  public void setProcessingResult(Boolean processingResult) {
    this.processingResult = processingResult;
  }

  public MortgageCaculatorResponse errorMessages(List<String> errorMessages) {
    this.errorMessages = errorMessages;
    return this;
  }

  public MortgageCaculatorResponse addErrorMessagesItem(String errorMessagesItem) {
    if (this.errorMessages == null) {
      this.errorMessages = new ArrayList<String>();
    }
    this.errorMessages.add(errorMessagesItem);
    return this;
  }

  /**
   * Get errorMessages
   * @return errorMessages
   **/
  @JsonProperty("error-messages")
  @Schema(description = "")
  public List<String> getErrorMessages() {
    return errorMessages;
  }

  public void setErrorMessages(List<String> errorMessages) {
    this.errorMessages = errorMessages;
  }

  public MortgageCaculatorResponse monthlyPayment(Double monthlyPayment) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MortgageCaculatorResponse mortgageCaculatorResponse = (MortgageCaculatorResponse) o;
    return Objects.equals(this.processingResult, mortgageCaculatorResponse.processingResult) &&
        Objects.equals(this.errorMessages, mortgageCaculatorResponse.errorMessages) &&
        Objects.equals(this.monthlyPayment, mortgageCaculatorResponse.monthlyPayment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processingResult, errorMessages, monthlyPayment);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    
    sb.append("    processing-result: ").append(toIndentedString(processingResult)).append("\n");
    sb.append("    error-messages: ").append(toIndentedString(errorMessages)).append("\n");
    sb.append("    monthly-payment: ").append(toIndentedString(monthlyPayment)).append("\n");
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
