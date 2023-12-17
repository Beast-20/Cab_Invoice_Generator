package com.example;

public class invoice {
    int numberOfRides;
    double totalFare;
    double averageFare;

    public invoice(int numberOfRides, double totalFare, double averageFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    public int getNumberOfRides() {
        return this.numberOfRides;
    }

    public double getTotalFare() {
        return this.totalFare;
    }

    public double getAverageFare() {
        return this.averageFare;
    }
}
