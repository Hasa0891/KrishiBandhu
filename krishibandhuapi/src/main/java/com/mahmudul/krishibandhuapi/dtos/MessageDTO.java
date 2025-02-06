package com.mahmudul.krishibandhuapi.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MessageDTO {
    
    @NotNull
    @Positive
    private Long senderId;
    
    @NotNull
    private String text;

}
