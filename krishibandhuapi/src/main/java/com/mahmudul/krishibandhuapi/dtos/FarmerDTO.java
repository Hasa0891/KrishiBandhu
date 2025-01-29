package com.mahmudul.krishibandhuapi.dtos;

import java.time.LocalDate;

import com.mahmudul.krishibandhuapi.enums.UserRole;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class FarmerDTO extends UserDTO {
    
    @NotBlank(message = "Present Address is required")
    private String presentAddress;
    
    @NotBlank(message = "Permanent Address is required")
    private String permanentAddress;
    
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
    
    public String getPresentAddress(){
        return presentAddress;
    }

    public String getPermanentAddress(){
        return permanentAddress;
    }

    public Double getLandArea(){
        return landArea;
    }

    public void setPresentAddress(String presentAddress){
        this.presentAddress = presentAddress;
    }

    public void setPermanentAddress(String permanentAddress){
        this.permanentAddress = permanentAddress;
    }

    public void setLandArea(Double landArea){
        this.landArea = landArea;
    }
}
