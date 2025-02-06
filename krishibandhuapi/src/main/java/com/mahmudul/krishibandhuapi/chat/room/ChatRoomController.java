package com.mahmudul.krishibandhuapi.chat.room;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahmudul.krishibandhuapi.dtos.ChatRoomDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/chatrooms")
@Validated
public class ChatRoomController {
    
    private ChatRoomService chatRoomService;

    public ChatRoomController(ChatRoomService chatRoomService){
        this.chatRoomService = chatRoomService;
    }

    @PostMapping("/")
    public ResponseEntity<ChatRoom> createChatRoom(@Valid @RequestBody ChatRoomDTO chatRoomDTO){
        
        ChatRoom chatRoom = chatRoomService.createChatRoom(chatRoomDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(chatRoom.getId())
                        .toUri();
        
        return ResponseEntity.created(location).body(chatRoom);
    }

    @GetMapping("/{chatRoomId}")
    public ResponseEntity<ChatRoom> getChatRoom(@PathVariable Long chatRoomId){
        ChatRoom chatRoom = chatRoomService.getChatRoom(chatRoomId);
        return ResponseEntity.ok(chatRoom);
    }
}
