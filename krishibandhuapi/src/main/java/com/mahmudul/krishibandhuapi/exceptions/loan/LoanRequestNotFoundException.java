package com.mahmudul.krishibandhuapi.exceptions.loan;

public class LoanRequestNotFoundException extends RuntimeException {
    public LoanRequestNotFoundException(String message){
        super(message);
    }
}
