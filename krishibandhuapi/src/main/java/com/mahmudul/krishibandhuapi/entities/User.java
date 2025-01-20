package com.mahmudul.krishibandhuapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String role;
    private String dob;

    public User(){}

    public User(String username, String email, String password, String role, String dob, String phone) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.dob = dob;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
}
