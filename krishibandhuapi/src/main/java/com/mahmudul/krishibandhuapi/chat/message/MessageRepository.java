package com.mahmudul.krishibandhuapi.chat.message;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
   
}