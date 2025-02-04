package com.mahmudul.krishibandhuapi.dtos;

import com.mahmudul.krishibandhuapi.crops.price.CropPrice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CropPriceDTO {
    
    @NotNull
    @Positive
    private Double price;
    
    @NotBlank
    private String unit;

    public CropPrice toCropPriceEntity(){
        CropPrice cropPrice = new CropPrice();
        cropPrice.setPrice(price);
        cropPrice.setUnit(unit);
        return cropPrice;
    }
}
