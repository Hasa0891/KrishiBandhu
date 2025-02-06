package com.mahmudul.krishibandhuapi.chat.room;

import org.springframework.stereotype.Service;

import com.mahmudul.krishibandhuapi.dtos.ChatRoomDTO;
import com.mahmudul.krishibandhuapi.exceptions.chat.ChatRoomNotFoundException;
import com.mahmudul.krishibandhuapi.exceptions.user.farmer.FarmerNotFoundException;
import com.mahmudul.krishibandhuapi.user.farmer.Farmer;
import com.mahmudul.krishibandhuapi.user.farmer.FarmerRepository;

@Service
public class ChatRoomService {
    
    private ChatRoomRepository chatRoomRepository;
    private FarmerRepository farmerRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository, FarmerRepository farmerRepository){
        this.chatRoomRepository = chatRoomRepository;
        this.farmerRepository = farmerRepository;
    }

    public ChatRoom createChatRoom(ChatRoomDTO chatRoomDTO){

        Farmer sender = farmerRepository.findById(chatRoomDTO.getSenderId())
            .orElseThrow(() -> new FarmerNotFoundException("Farmer Not Found with Id : "  + chatRoomDTO.getSenderId()));

        Farmer receiver = farmerRepository.findById(chatRoomDTO.getReceiverId())
            .orElseThrow(() -> new FarmerNotFoundException("Farmer Not Found with Id : "  + chatRoomDTO.getSenderId()));
        
        ChatRoom chatRoom = new ChatRoom(sender, receiver);

        return chatRoomRepository.save(chatRoom);
    }

    public ChatRoom getChatRoom(Long chatRoomId){
        return chatRoomRepository.findById(chatRoomId)
                .orElseThrow(() -> new ChatRoomNotFoundException("ChatRoom Not Found with Id : " + chatRoomId));
    }

}
