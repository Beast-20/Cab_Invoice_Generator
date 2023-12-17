package com.example;

public enum Type {
    ECONOMY(10.0, 1.0, 5.0),
    DELUXE(15.0, 2.0, 20.0);

    double FARE_PER_KM;
    double FARE_PER_MIN;
    double MINIMUM_FARE;

    private Type(double FARE_PER_KM, double FARE_PER_MIN, double MINIMUM_FARE) {
        this.FARE_PER_KM = FARE_PER_KM;
        this.FARE_PER_MIN = FARE_PER_MIN;
        this.MINIMUM_FARE = MINIMUM_FARE;
    }
}
