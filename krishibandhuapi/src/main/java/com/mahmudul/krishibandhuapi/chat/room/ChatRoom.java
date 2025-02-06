package com.mahmudul.krishibandhuapi.chat.room;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahmudul.krishibandhuapi.chat.message.Message;
import com.mahmudul.krishibandhuapi.user.farmer.Farmer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "chatroom")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ChatRoom {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    Farmer sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    Farmer receiver;

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Message> messages;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public ChatRoom(Farmer sender, Farmer receiver){
        this.sender = sender;
        this.receiver = receiver;
    }
}
