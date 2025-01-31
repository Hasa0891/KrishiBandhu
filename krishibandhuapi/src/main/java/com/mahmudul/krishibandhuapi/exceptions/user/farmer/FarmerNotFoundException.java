package com.mahmudul.krishibandhuapi.exceptions.user.farmer;

public class FarmerNotFoundException extends RuntimeException{
    public FarmerNotFoundException(String message){
        super(message);
    }
}