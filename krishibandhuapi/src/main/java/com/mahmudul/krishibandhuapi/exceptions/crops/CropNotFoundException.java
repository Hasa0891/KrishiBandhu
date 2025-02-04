package com.mahmudul.krishibandhuapi.exceptions.crops;

public class CropNotFoundException extends RuntimeException {
    public CropNotFoundException(String message){
        super(message);
    }
}
