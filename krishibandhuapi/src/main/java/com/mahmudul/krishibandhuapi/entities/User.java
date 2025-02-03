package com.mahmudul.krishibandhuapi.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String role;
    private LocalDate dob;

    public User(
        String username, 
        String email, 
        String password, 
        String role, 
        LocalDate dob, 
        String phone
    ) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.dob = dob;
        this.phone = phone;
    }
}
