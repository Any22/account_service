package com.fin_app.account_service.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @Autowired
    private Environment environment;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> noResourceFoundExceptionHandler(ResourceNotFoundException ex) {

        ErrorMessage error = new ErrorMessage();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setMessage("no resourcse found.Please check uri is valid or not");

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }


}
