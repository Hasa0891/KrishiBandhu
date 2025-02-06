package com.mahmudul.krishibandhuapi.chat.message;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mahmudul.krishibandhuapi.chat.room.ChatRoom;
import com.mahmudul.krishibandhuapi.chat.room.ChatRoomRepository;
import com.mahmudul.krishibandhuapi.dtos.MessageDTO;
import com.mahmudul.krishibandhuapi.exceptions.chat.ChatRoomNotFoundException;
import com.mahmudul.krishibandhuapi.exceptions.user.farmer.FarmerNotFoundException;
import com.mahmudul.krishibandhuapi.user.farmer.Farmer;
import com.mahmudul.krishibandhuapi.user.farmer.FarmerRepository;

@Service
public class MessageService {
    
    private MessageRepository messageRepository;
    private ChatRoomRepository chatRoomRepository;
    private FarmerRepository farmerRepository;

    public MessageService(
        MessageRepository messageRepository, 
        ChatRoomRepository chatRoomRepository,
        FarmerRepository farmerRepository
    ){
        this.messageRepository = messageRepository;
        this.chatRoomRepository = chatRoomRepository;
        this.farmerRepository = farmerRepository;
    }

    public Message createMessage(Long chatRoomId, MessageDTO messageDTO){
        
        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId)
        .orElseThrow(() -> new ChatRoomNotFoundException("ChatRoom Not Found with Id : " + chatRoomId));
        
        Farmer sender = farmerRepository.findById(messageDTO.getSenderId())
        .orElseThrow(() -> new FarmerNotFoundException("Farmer Not Found with Id : " + messageDTO.getSenderId()));

        Message msg = new Message(chatRoom, sender, messageDTO.getText());
        
        return messageRepository.save(msg);
    }

    public List<Message> getMessages(Long chatRoomId){
        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId)
        .orElseThrow(() -> new ChatRoomNotFoundException("ChatRoom Not Found with Id : " + chatRoomId));

        List<Message> messages = chatRoom.getMessages();
        return messages;
    }

}
