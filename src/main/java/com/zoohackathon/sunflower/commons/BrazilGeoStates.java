package com.zoohackathon.sunflower.commons;

import java.util.Arrays;
import java.util.List;

public enum BrazilGeoStates {

    AC(-8.77, -70.55),
    AL(-9.71, -35.73),
    AM(-3.07, -61.66),
    AP(1.41, -51.77),
    BA(-12.96, -38.51),
    CE(-3.71, -38.54),
    DF(-15.83, -47.86),
    ES(-19.19, -40.34),
    GO(-16.64, -49.31),
    MA(-2.55, -44.30),
    MT(-12.64, -55.42),
    MS(-20.51, -54.54),
    MG(-18.10, -44.38),
    PA(-5.53, -52.29),
    PB(-7.06, -35.55),
    PR(-24.89, -51.55),
    PE(-8.28, -35.07),
    PI(-8.28, -43.68),
    RJ(-22.84, -43.15),
    RN(-5.22, -36.52),
    RO(-11.22, -62.80),
    RS(-30.01, -51.22),
    RR(1.89, -61.22),
    SC(-27.33, -49.44),
    SE(-10.90, -37.07),
    SP(-23.55, -46.64),
    TO(-10.25, -48.25);

    private double longitude;

    private double latitude;

    BrazilGeoStates(double longitude, double latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static BrazilGeoStates getState(double longitude, double latitude) {
        List<BrazilGeoStates> brazilGeoStates = Arrays.asList(BrazilGeoStates.values());

        double longi = 0;
        for (int i = 0; i < brazilGeoStates.size(); i++) {
            if(brazilGeoStates.get(i).longitude <= latitude & brazilGeoStates.get(i).longitude >= longi){
                longi = brazilGeoStates.get(i).longitude;
            }
        }

        final double l = longi;
        BrazilGeoStates bra = brazilGeoStates.stream()
                .filter(brazilGeoStatess -> brazilGeoStatess.longitude == l)
                .findFirst()
                .get();
        return bra;

    }

}
