package com.mahmudul.krishibandhuapi.dtos;

import com.mahmudul.krishibandhuapi.loan.offer.LoanOffer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class LoanOfferDTO {
    
    @NotBlank
    private String name;

    @NotBlank
    private String description;
    
    @NotBlank
    private String terms;
    
    @NotNull
    @Positive
    private Double amount;
    
    @NotNull
    @Positive
    private Long orgId;

    public LoanOffer toLoanOfferEntity(){
        return new LoanOffer(name, description, terms, amount, null);
    }
}
