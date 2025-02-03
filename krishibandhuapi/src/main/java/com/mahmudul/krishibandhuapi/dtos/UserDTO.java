package com.mahmudul.krishibandhuapi.dtos;

import com.mahmudul.krishibandhuapi.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public abstract class UserDTO {

    @Email(message = "Please provide a valid email address")
    @NotBlank(message = "Email is required")
    private String email;

    private String phone;

    @NotBlank
    @Size(min=6,message="Password must be at least 6 characters long")
    private String password;

    @NotNull(message = "Role is required")
    private UserRole role;

    @NotNull(message = "Date of Birth is required")
    private LocalDate dob;

    public UserDTO(String email, String password, UserRole role, LocalDate dob, String phone) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.dob = dob;
        this.phone = phone;
    }
}
