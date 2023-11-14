package com.coders.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleStatusDTO {
    private Integer id;
    private boolean hasDamage;
    private boolean isColourChanged;
    private boolean isCrashed;
}
