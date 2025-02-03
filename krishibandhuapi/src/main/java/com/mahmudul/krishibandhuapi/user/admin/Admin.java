package com.mahmudul.krishibandhuapi.user.admin;

import java.time.LocalDate;

import com.mahmudul.krishibandhuapi.entities.User;

import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "admins")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Admin extends User {

  private String responsibility;

  public Admin(
    String username, 
    String email, 
    String password, 
    String role, 
    LocalDate dob,
    String phone,
    String responsibility
  ) {
    super(username, email, password, role, dob, phone);
    this.responsibility = responsibility;
  }

  @PrePersist
  public void generateAdminUserName(){
    this.setUsername("ADMIN_" + System.currentTimeMillis());
  }
}
