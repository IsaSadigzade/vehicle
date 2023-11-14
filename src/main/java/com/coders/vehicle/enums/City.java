package com.coders.vehicle.enums;

public enum City {
    ABADEH("Abadə"),
    AGDAM("Ağdam"),
    AGDASH("Ağdaş"),
    AGDAS("Ağdaş"),
    AGLAYAN("Ağlayan"),
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
    HACI_ZEYNALABDIN("Hacı Zeynalabdin"),
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
    YARDYMLI("Yardımlı"),
    YEVLAKH("Yevlax"),
    ZARDAB("Zərdab");

    private final String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}
