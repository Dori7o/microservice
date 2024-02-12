package com.eazybytes.loan.exception;

public class LoanAlreadyExistsException extends RuntimeException{
    public LoanAlreadyExistsException(String message){
        super(message);
    }
}
