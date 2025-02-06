package com.mahmudul.krishibandhuapi.dtos;

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
public class LoanRequestDTO {

    @NotNull
    @Positive
    private Long loanOfferId;
    
    @NotNull
    @Positive
    private Long farmerId;
    
    @NotBlank
    private String status;
}
