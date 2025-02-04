package com.mahmudul.krishibandhuapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class CropWithPrice {

    private Long id;
    private String name;
    private Double price;
    private String unit;
}
