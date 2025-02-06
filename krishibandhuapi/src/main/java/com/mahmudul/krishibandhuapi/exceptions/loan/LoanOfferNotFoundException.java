package com.mahmudul.krishibandhuapi.exceptions.loan;

public class LoanOfferNotFoundException extends RuntimeException {
    public LoanOfferNotFoundException(String message){
        super(message);
    }
}
