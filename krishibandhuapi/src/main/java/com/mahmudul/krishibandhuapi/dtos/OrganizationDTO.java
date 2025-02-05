package com.mahmudul.krishibandhuapi.dtos;

import com.mahmudul.krishibandhuapi.organization.Organization;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class OrganizationDTO {

    @NotBlank
    private String name;
    
    @NotBlank
    private String description;
    
    @NotBlank
    private String address;
    
    @NotBlank
    private String contacts;

    public Organization toOrganizationEntity(){
        return new Organization(name,description,address,contacts);
    }
}
