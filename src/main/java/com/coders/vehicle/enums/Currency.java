package com.coders.vehicle.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currency {
    AZN("azn"),
    USD("usd"),
    EUR("eur");


    private String currencyName;
}
