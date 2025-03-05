package com.fin_app.account_service.controller;

import com.fin_app.account_service.dto.NewAccount;
import com.fin_app.account_service.dto.NewAccountRequest;
import com.fin_app.account_service.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Slf4j
@Validated
@RequiredArgsConstructor
public class AccountController {
    private  final AccountService accountService;

    @PostMapping(value={"v1/api/accounts"}, consumes= APPLICATION_JSON_VALUE)
    public ResponseEntity<NewAccount> creatingNewAccount(@Valid @RequestBody NewAccountRequest newAccountRequest){

        try{
             NewAccount response = accountService.createNewAccount(newAccountRequest);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
