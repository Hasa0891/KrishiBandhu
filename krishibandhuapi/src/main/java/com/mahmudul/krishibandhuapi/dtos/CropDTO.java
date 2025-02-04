package com.mahmudul.krishibandhuapi.dtos;

import com.mahmudul.krishibandhuapi.crops.info.Crop;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CropDTO {

    @NotBlank(message = "Crop Type is Required")
    private String type;
    
    @NotBlank(message = "Crop Name is Required")
    private String name;

    @NotBlank(message = "Crop Description is Required")
    private String description;

    public Crop toCropEntity(){
        Crop crp = new Crop();
        crp.setType(type);
        crp.setName(name);
        crp.setDescription(description);
        return crp;
    }
}
