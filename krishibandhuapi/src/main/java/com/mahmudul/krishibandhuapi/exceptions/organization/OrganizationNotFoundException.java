package com.mahmudul.krishibandhuapi.exceptions.organization;

public class OrganizationNotFoundException extends RuntimeException{
    public OrganizationNotFoundException(String message){
        super(message);
    }
}
