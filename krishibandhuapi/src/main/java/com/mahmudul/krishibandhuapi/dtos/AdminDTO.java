package com.mahmudul.krishibandhuapi.dtos;

import com.mahmudul.krishibandhuapi.enums.AdminResponsibility;
import com.mahmudul.krishibandhuapi.enums.UserRole;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class AdminDTO extends UserDTO {

  @NotBlank(message = "Responsibility is required")
  private AdminResponsibility responsibility;

  public AdminDTO(
    String username,
    String email, 
    String password, 
    UserRole role, 
    LocalDate dob,
    String phone,
    AdminResponsibility responsibility
  ) {
      super(username,email,password,role,dob,phone);
      this.responsibility = responsibility;
  }

  public AdminResponsibility getResponsibility() {
      return responsibility;
  }

  public void setResponsibility(AdminResponsibility responsibility) {
      this.responsibility = responsibility;
  }
}
