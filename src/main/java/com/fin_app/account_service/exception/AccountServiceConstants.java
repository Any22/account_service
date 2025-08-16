package com.fin_app.account_service.exception;

public enum AccountServiceConstants {

        GENERAL_EXCEPTION_MESSAGE("general.exception"),
        NO_DATA_FOUND_MESSAGE("no.data.found.exception");


        private final String type;

        AccountServiceConstants(String type) {
            this.type = type;
        }
        @Override
        public String toString(){
            return this.type;
        }
    }

