package com.fin_app.account_service.mapper;

import com.fin_app.account_service.dto.Balance;
import com.fin_app.account_service.dto.NewAccount;
import com.fin_app.account_service.dto.NewAccountRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class MapperClass {
    public NewAccount responseToStoreInRepository(@Valid NewAccountRequest newAccountRequest) {
        String accountType = newAccountRequest.getAccountType(); // Extract account type first
        Double interestRate = getInterestRate(accountType); // Determine interest rate before building object
        return NewAccount
                .builder()
                .accountHolderName(newAccountRequest.getAccountHolderName())
                .accountType(accountType)
                .balance(Balance.builder().currency(newAccountRequest.getCurrency()).value(newAccountRequest.getBalance()).build())
                .branchCode(newAccountRequest.getBranchCode())
                .interestRate(interestRate)
                .build();

    }

    private Double getInterestRate(String accountType) {
        switch (accountType.toUpperCase()) {
            case "SAVINGS":
                return 2.5;
            case "CHECKING":
                return 0.5;
            case "BUSINESS":
                return 1.5;
            default:
                return 0.0; // Default for unknown types
        }
    }
}






