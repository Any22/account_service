package com.fin_app.account_service.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fin_app.account_service.dto.Balance;
import com.fin_app.account_service.dto.Customer;
import com.fin_app.account_service.dto.NewAccount;
import com.fin_app.account_service.dto.NewAccountRequest;
import com.fin_app.account_service.entity.NewAccountEntity;
import com.fin_app.account_service.mapper.MapperClass;
import com.fin_app.account_service.respository.AccountRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {
    private final WebClient webclient ;
    private final ObjectMapper objectMapper;
    private final MapperClass mapper;
    private final AccountRepository repository;

/// explore Entity manager in persistence context ms-nt-investor-accounts

    public String createNewAccount(@Valid NewAccountRequest newAccountRequest) throws Exception {
        String customerId = newAccountRequest.getCustomerId();
        long customerIdLong = Long.parseLong(customerId);
        log.info("The customer id we are looking for is {}", customerIdLong);
        if (repository.existsByCustomerId(customerIdLong)) {
            // Optional: handle duplicate case or just return
            // Account already exists, fetch the account ID
            Optional<NewAccountEntity> existing = repository.findByCustomerId(customerIdLong);
            Long existingAccountId = existing.map(NewAccountEntity::getAccountId)
                    .orElse(null);
            return "Account already exists for customerId " + customerIdLong
                    + ". Account ID: " + existingAccountId;
        }

        Customer responseDTO = webclient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/fetch/{customerId}")
                        .build(customerId))
                .retrieve()
                .bodyToMono(Customer.class)
                .block();
        log.info("Response:{}",responseDTO);

        if (responseDTO == null){
             return "Account cannot be created for a non-existing user. ";
        }

       NewAccount dto =  NewAccount.builder().customerId(responseDTO.getCustomerId()).userName(responseDTO.getUserName()).balance(Balance.builder().amount(newAccountRequest.getAmount()).currency(newAccountRequest.getCurrency()).build()).build();
        log.info("The response in DTO is {}", dto);
        Long accountNumber=  mapper.mapToAccount(responseDTO,newAccountRequest);


       // Long accountId =  mapper.responseToStoreInRepository( newAccountRequest,userName,custId);
        return "Congratulations! The account is successfully created. Account number : " + accountNumber;
    }

}
