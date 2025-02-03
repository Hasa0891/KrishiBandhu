package com.mahmudul.krishibandhuapi.dtos;

import java.time.LocalDate;

import com.mahmudul.krishibandhuapi.enums.UserRole;
import com.mahmudul.krishibandhuapi.user.farmer.Farmer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FarmerDTO extends UserDTO {
    
    @NotBlank(message = "Present Address is required")
    private String presentAddress;
    
    @NotBlank(message = "Permanent Address is required")
    private String permanentAddress;
    
    @NotNull(message = "Land Area is required")
    @Positive(message = "Land Area must be positive")
    private Double landArea;

    public FarmerDTO(
        String username, 
        String email, 
        String password, 
        UserRole role, 
        LocalDate dob, 
        String phone, 
        String presentAddress, 
        String permanentAddress,
        Double landArea
    ){
        super(username, email, password, role, dob, phone);
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.landArea = landArea;
    }

    public Farmer toFarmerEntity(){
        Farmer farmer = new Farmer();
        farmer.setUsername(this.getUsername());
        farmer.setEmail(this.getEmail());
        farmer.setPassword(this.getPassword());
        farmer.setRole(this.getRole().toString());
        farmer.setDob(this.getDob());
        farmer.setPhone(this.getPhone());
        farmer.setPresentAddress(this.getPresentAddress());
        farmer.setPermanentAddress(this.getPermanentAddress());
        farmer.setLandArea(this.getLandArea());
        return farmer;
    }
}
