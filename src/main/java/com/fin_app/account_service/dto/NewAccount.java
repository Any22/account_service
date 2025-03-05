package com.fin_app.account_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class NewAccount {
   // private String customerId;
    private String accountHolderName;
    private String accountType;
    private Balance balance;
    private String branchCode;
    private Double interestRate;

 }


