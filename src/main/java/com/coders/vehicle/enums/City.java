package com.coders.vehicle.enums;

import lombok.Getter;

@Getter
public enum City {
    AGDAM("Ağdam"),
    AGDASH("Ağdaş"),
    ASTARA("Astara"),
    BAKU("Bakı"),
    BABEK("Babək"),
    BARDA("Bərdə"),
    BEYLEGAN("Beyləqan"),
    BILASUVAR("Biləsuvar"),
    DASHKASAN("Daşkəsən"),
    GADABAY("Gədəbəy"),
    GANJA("Gəncə"),
    GORANBOY("Goranboy"),
    GOYCHAY("Göyçay"),
    GUBA("Quba"),
    JALILABAD("Cəlilabad"),
    KHACHMAZ("Xaçmaz"),
    KURDAEMIR("Qurdamır"),
    LANKARAN("Lənkəran"),
    LERIK("Lerik"),
    MINGACHEVIR("Mingəçevir"),
    NAKHCHIVAN("Naxçıvan"),
    OGHUZ("Oğuz"),
    ORDUBAD("Ordubad"),
    QAZAX("Qazax"),
    SABIRABAD("Səbirabad"),
    SAMUKH("Samux"),
    SHAKI("Şəki"),
    SHAMAKHI("Şamaxı"),
    SHAMKIR("Şəmkir"),
    SHIRVAN("Şirvan"),
    SIAZAN("Siyəzən"),
    SUMGAYIT("Sumqayıt"),
    TOVUZ("Tovuz"),
    UJAR("Ucar"),
    YARDIMLI("Yardımlı"),
    YEVLAKH("Yevlax"),
    ZARDAB("Zərdab");

    private final String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }
}
