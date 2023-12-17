package com.example;

public class Ride {
    int userId;
    double rideDistance;
    double rideTime;
    Type rideType;

    public Ride(int userId, double rideDistance, double rideTime, Type rideType) {
        this.userId = userId;
        this.rideDistance = rideDistance;
        this.rideTime = rideTime;
        this.rideType = rideType;

        RideRepository.addRide(userId, this);
    }
}
