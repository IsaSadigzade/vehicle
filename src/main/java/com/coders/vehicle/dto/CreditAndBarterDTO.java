package com.coders.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtrasDTO {
    private Integer id;
    private boolean hasCredit;
    private boolean isBarterPossible;
}
