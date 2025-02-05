package com.mahmudul.krishibandhuapi.exceptions.posts;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message){
        super(message);
    }
}
