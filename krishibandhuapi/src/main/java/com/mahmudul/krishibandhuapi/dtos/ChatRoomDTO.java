package com.mahmudul.krishibandhuapi.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class ChatRoomDTO {

    @NotNull
    @Positive
    private Long senderId;
    
    @NotNull
    @Positive
    private Long receiverId;
}
