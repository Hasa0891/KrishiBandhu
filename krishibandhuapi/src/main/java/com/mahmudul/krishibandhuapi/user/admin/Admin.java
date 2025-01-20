package com.mahmudul.krishibandhuapi.user.admin;

import com.mahmudul.krishibandhuapi.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {
  private String responsibility;

  public Admin(){}

  public Admin(String username, String email, String password, String role, String dob, String phone, String responsibility) {
    super(username, email, password, role, dob, phone);
    this.responsibility = responsibility;
  }

  public String getResponsibility(){
    return responsibility;
  }

  public void setResponsibility(String responsibility){
    this.responsibility = responsibility;
  }

}
