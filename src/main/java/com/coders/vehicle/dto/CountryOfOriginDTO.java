package com.coders.vehicle.dto;

import com.coders.vehicle.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryOfOriginDTO {
    private Integer id;
    private Country countryName;
}
