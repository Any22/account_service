package com.fin_app.account_service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewAccountRequest {
   @NotNull(message = "Customer ID is required")
   private String customerId;

   @NotNull(message = "Balance cannot be null")
   @DecimalMin(value = "0.0", inclusive = false, message = "An initial amount should be provided to open an account")
   private BigDecimal amount;

   @NotBlank(message = "Currency is required")
   private String currency;
}

