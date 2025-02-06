package com.mahmudul.krishibandhuapi.chat.message;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.mahmudul.krishibandhuapi.chat.room.ChatRoom;
import com.mahmudul.krishibandhuapi.user.farmer.Farmer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "message")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Farmer sender;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String text;

    public Message(ChatRoom chatRoom, Farmer sender, String text){
        this.chatRoom = chatRoom;
        this.sender = sender;
        this.text = text;
    }
}
