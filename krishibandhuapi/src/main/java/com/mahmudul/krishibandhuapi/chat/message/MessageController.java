package com.mahmudul.krishibandhuapi.chat.message;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahmudul.krishibandhuapi.dtos.MessageDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/chatrooms/{chatRoomId}/messages")
@Validated
public class MessageController {
    
    private MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @PostMapping("/")
    public ResponseEntity<Message> sendMessage(@PathVariable Long chatRoomId, @Valid @RequestBody MessageDTO messageDTO){
        Message msg = messageService.createMessage(chatRoomId, messageDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(msg.getId())
                        .toUri();
        return ResponseEntity.created(location).body(msg);
    }

    @GetMapping("/")
    public ResponseEntity<List<Message>> getMessages(@PathVariable Long chatRoomId){
        List<Message> messages = messageService.getMessages(chatRoomId);
        return ResponseEntity.ok(messages);
    }

}
