package com.mahmudul.krishibandhuapi.user.farmer;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahmudul.krishibandhuapi.chat.message.Message;
import com.mahmudul.krishibandhuapi.chat.room.ChatRoom;
import com.mahmudul.krishibandhuapi.entities.User;
import com.mahmudul.krishibandhuapi.loan.request.LoanRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "farmers")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Farmer extends User {

  private String presentAddress;
  private String permanentAddress;
  private Double landArea;
  
  @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<LoanRequest> loanRequests;

  @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<ChatRoom> chatRoomsAsSender;

  @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<ChatRoom> chatRoomsAsReceiver;

  @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<Message> messages;

  public Farmer(
    String username, 
    String email, 
    String password, 
    String role, 
    LocalDate dob, 
    String phone, 
    String presentAddress, 
    String permanentAddress,
    Double landArea
    ) {
      super(username, email, password, role, dob, phone);
      this.presentAddress = presentAddress;
      this.permanentAddress = permanentAddress;
      this.landArea = landArea;
  }

  @PrePersist
  public void generateFarmerUserName(){
    this.setUsername("FARMER_" + System.currentTimeMillis());
  }
  
}
