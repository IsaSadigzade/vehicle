package com.coders.vehicle.dto;

import com.coders.vehicle.enums.Country;
import lombok.Data;

@Data
public class CountryOfOriginDTO {
    private Integer id;
    private Country countryName;
}
