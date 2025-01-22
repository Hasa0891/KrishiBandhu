package com.mahmudul.krishibandhuapi.user.farmer;

import java.util.List;

import com.mahmudul.krishibandhuapi.entities.User;
import com.mahmudul.krishibandhuapi.loan.request.LoanRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "farmers")
public class Farmer extends User {
  private String presentAddress;
  private String permanentAddress;
  private Long landArea;
  
  @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<LoanRequest> loanRequests;

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

  public List<LoanRequest> getLoanRequests(){
    return loanRequests;
  }

  public void setLoanRequest(List<LoanRequest> loanRequests){
    this.loanRequests = loanRequests;
  }

}
