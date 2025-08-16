package com.fin_app.account_service.exception;

import java.io.Serial;

public class NoDataFoundException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public NoDataFoundException() {

        super();
    }

    public NoDataFoundException(String message) {
        super(message);
    }

}
