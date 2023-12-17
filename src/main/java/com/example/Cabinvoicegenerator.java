package com.example;

import java.util.ArrayList;

public class Cabinvoicegenerator {
    static double FARE_PER_KM = 10.0;
    static double FARE_PER_MIN = 1.0;
    static double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, double time) {
        double fare = distance * FARE_PER_KM + time * FARE_PER_MIN;
        return Math.max(fare, MINIMUM_FARE);
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            double fare = ride.rideDistance * ride.rideType.FARE_PER_KM + ride.rideTime * ride.rideType.FARE_PER_MIN;
            totalFare += Math.max(fare, ride.rideType.MINIMUM_FARE);
        }
        return totalFare;
    }

    public invoice generateInvoice(Ride[] rides) {
        int numberOfRides = rides.length;
        double totalFare = calculateFare(rides);
        double averageFare = totalFare / numberOfRides;
        return new invoice(numberOfRides, totalFare, averageFare);
    }

    public invoice generateInvoiceForUser(int userId) {
        ArrayList<Ride> ridesList = RideRepository.getAllRides(userId);
        int numberOfRides = ridesList.size();
        Ride[] rides = new Ride[numberOfRides];
        for (int i = 0; i < numberOfRides; i++) {
            rides[i] = ridesList.get(i);
        }
        return this.generateInvoice(rides);
    }
}
