package com.coders.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarMileageDTO {
    private Integer id;
    private BigDecimal mileageValue;
    private String mileageUnit;
}
