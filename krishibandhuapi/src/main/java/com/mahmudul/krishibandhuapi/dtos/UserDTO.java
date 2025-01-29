package com.mahmudul.krishibandhuapi.dtos;

import com.mahmudul.krishibandhuapi.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public abstract class UserDTO {

    @NotBlank(message = "Username is required")
    @Size(min = 6, max = 20)
    private String username;

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

    public UserDTO(String username, String email, String password, UserRole role, LocalDate dob, String phone) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.dob = dob;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
