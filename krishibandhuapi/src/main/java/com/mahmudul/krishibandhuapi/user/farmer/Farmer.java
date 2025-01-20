package com.mahmudul.krishibandhuapi.user.farmer;

import com.mahmudul.krishibandhuapi.entities.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "farmers")
public class Farmer extends User {
  private String presentAddress;
  private String permanentAddress;
  private Long landArea;

  public Farmer(){}
  public Farmer(String username, 
                String email, 
                String password, 
                String role, 
                String dob, 
                String phone, 
                String presentAddress, 
                String permanentAddress,
                Long landArea) {
    super(username, email, password, role, dob, phone);
    this.presentAddress = presentAddress;
    this.permanentAddress = permanentAddress;
    this.landArea = landArea;
  }

  public String getPresentAddress(){
    return presentAddress;
  }

  public String getPermanentAddress(){
    return permanentAddress;
  }

  public Long getLandArea(){
    return landArea;
  }

  public void setPresentAddress(String presentAddress){
    this.presentAddress = presentAddress;
  }

  public void setPermanentAddress(String permanentAddress){
    this.permanentAddress = permanentAddress;
  }

  public void setLandArea(Long landArea){
    this.landArea = landArea;
  }

}
