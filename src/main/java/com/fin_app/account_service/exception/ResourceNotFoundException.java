package com.fin_app.account_service.exception;

import java.io.Serial;

public class ResourceNotFoundException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
