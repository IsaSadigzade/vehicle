package com.coders.vehicle.dto;

import com.coders.vehicle.enums.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
    private Integer id;
    private City cityName;
}
