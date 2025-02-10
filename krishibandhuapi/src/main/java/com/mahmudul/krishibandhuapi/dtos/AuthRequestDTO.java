package com.mahmudul.krishibandhuapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AuthRequestDTO {
    private String username;
    private String password;
}
