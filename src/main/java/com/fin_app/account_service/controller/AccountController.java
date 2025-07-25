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
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/api/accounts")
@Slf4j
@Validated
@RequiredArgsConstructor
public class AccountController {
    private  final AccountService accountService;
    // As a registered user, I should be able to create a new account
    @PostMapping(value={"/account"}, consumes= APPLICATION_JSON_VALUE)
    public Callable<ResponseEntity<String>> creatingNewAccount(@Valid @RequestBody NewAccountRequest newAccountRequest){
        try{
            return ()-> {
                String message = accountService.createNewAccount(newAccountRequest);
                return new ResponseEntity<>(message,HttpStatus.CREATED);
            };
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



}
