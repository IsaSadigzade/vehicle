package com.coders.vehicle.enums;

import lombok.Getter;

@Getter
public enum Country {
    AMERICA("America"),
    EUROPE("Europe"),
    CHINA("China"),
    DUBAI("Dubai"),
    KOREA("Korea"),
    RUSSIA("Russia"),
    JAPAN("Japan"),
    OFFICIAL_DEALER("Official Dealer");

    private final String displayName;
    Country(String displayName) {
        this.displayName = displayName;
    }
}
