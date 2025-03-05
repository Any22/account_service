package com.fin_app.account_service.service;

import com.fin_app.account_service.dto.NewAccount;
import com.fin_app.account_service.dto.NewAccountRequest;
import com.fin_app.account_service.entity.NewAccountEntity;
import com.fin_app.account_service.mapper.MapperClass;
import com.fin_app.account_service.respository.AccountRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final MapperClass mapper;
    private final AccountRepository accountRepository;

    public NewAccount createNewAccount(@Valid NewAccountRequest newAccountRequest) {
        NewAccount newAccount = mapper.responseToStoreInRepository(newAccountRequest);
        NewAccountEntity accountEntity= this.convertToEntity(newAccount);
        this.savingToDb(accountEntity);
        return  newAccount;
    }

    private NewAccountEntity convertToEntity(NewAccount account) {

        return NewAccountEntity.builder()
                .accountHolderName(account.getAccountHolderName())
                .accountType(account.getAccountType())
                .branchCode(account.getBranchCode())
                .currency(account.getBalance().getCurrency())
                .value(account.getBalance().getValue())
                .interestRate(account.getInterestRate())
                .build();
    }

    private void savingToDb(NewAccountEntity newAccountEntity) {
        accountRepository.save(newAccountEntity);
    }
}
