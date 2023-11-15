package com.coders.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnginePowerDTO {
    private Integer id;
    private Integer powerAmount;
    private String powerUnit;
}
