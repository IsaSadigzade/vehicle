package com.coders.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelDTO {
    private Integer id;
    private String modelName;
    private BrandDTO brandDTO;
}
