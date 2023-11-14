package com.coders.vehicle.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currency {
    USD("usd"),
    EUR("eur"),
    AZN("azn");

    private String currencyName;
}
