package com.mahmudul.krishibandhuapi.dtos;

import com.mahmudul.krishibandhuapi.enums.AdminResponsibility;
import com.mahmudul.krishibandhuapi.enums.UserRole;
import com.mahmudul.krishibandhuapi.user.admin.Admin;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class AdminDTO extends UserDTO {

  @NotNull(message = "Responsibility is required")
  private AdminResponsibility responsibility;

  public AdminDTO(
    String email, 
    String password, 
    UserRole role, 
    LocalDate dob,
    String phone,
    AdminResponsibility responsibility
  ) {
      super(email,password,role,dob,phone);
      this.responsibility = responsibility;
  }

  public Admin toAdminEntity() {  
    Admin admin = new Admin();
    admin.setEmail(this.getEmail());
    admin.setPassword(this.getPassword());
    admin.setRole(this.getRole().toString());
    admin.setDob(this.getDob());
    admin.setPhone(this.getPhone());
    admin.setResponsibility(this.getResponsibility().toString());
    return admin;
  }
}
