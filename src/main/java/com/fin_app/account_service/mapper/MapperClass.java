package com.fin_app.account_service.mapper;

import com.fin_app.account_service.dto.Balance;
import com.fin_app.account_service.dto.Customer;
import com.fin_app.account_service.dto.NewAccount;
import com.fin_app.account_service.dto.NewAccountRequest;
import com.fin_app.account_service.entity.NewAccountEntity;
import com.fin_app.account_service.exception.NoDataFoundException;
import com.fin_app.account_service.respository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class MapperClass {
    private final AccountRepository accountRepository;

    public Long mapToAccount (Customer customer, NewAccountRequest newAccountRequest) throws NoDataFoundException {
      NewAccount dto =  NewAccount.builder()
              .customerId(customer.getCustomerId())
              .userName(customer.getUserName())
              .balance(Balance.builder()
                      .currency(newAccountRequest.getCurrency())
                      .amount(newAccountRequest.getAmount())
                      .build())
              .build();

    return this.convertToEntity(dto);
    }

    public Long convertToEntity (NewAccount newAccount) throws NoDataFoundException {
        NewAccountEntity newAccount1 = NewAccountEntity.builder()
                .customerId(newAccount.getCustomerId())
                .userName(newAccount.getUserName())
                .balance(Balance.builder()
                        .currency(newAccount.getBalance().getCurrency())
                        .amount(newAccount.getBalance().getAmount())
                        .build())

                .build();
log.info("Inside entity function : {}", newAccount1.getCustomerId());
        this.savingToDb(newAccount1);
      return this.gettingFromDb(newAccount1.getCustomerId());
    }

    private void savingToDb(NewAccountEntity entity) {
        accountRepository.saveAndFlush(entity);
    }

    private Long gettingFromDb (Long customerId) throws NoDataFoundException {
        NewAccountEntity newAccountEntity= accountRepository.findById(customerId)
                .orElseThrow(() -> new NoDataFoundException("Customer not found with id: " + customerId));
        log.info("The account Entity is {}",newAccountEntity.getAccountId());
        return newAccountEntity.getAccountId();

    }
}






