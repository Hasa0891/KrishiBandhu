package com.mahmudul.krishibandhuapi.exceptions.chat;

public class ChatRoomNotFoundException extends RuntimeException {
    public ChatRoomNotFoundException(String message){
        super(message);
    }
}
