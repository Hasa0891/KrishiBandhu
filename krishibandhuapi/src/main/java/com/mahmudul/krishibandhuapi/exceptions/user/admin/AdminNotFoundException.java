package com.mahmudul.krishibandhuapi.exceptions.user.admin;

public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException(String message){
        super(message);
    }
}
