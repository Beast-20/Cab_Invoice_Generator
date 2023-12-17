package com.example;

import java.util.ArrayList;
import java.util.HashMap;

public class RideRepository {
    static HashMap<Integer, ArrayList<Ride>> userRidesMap = new HashMap<>();

    public static void addRide(int userId, Ride ride) {
        ArrayList<Ride> ridesList;
        if (userRidesMap.containsKey(userId)) {
            ridesList = userRidesMap.get(userId);
        } else {
            ridesList = new ArrayList<>();
        }
        ridesList.add(ride);
        userRidesMap.put(userId, ridesList);
    }

    public static ArrayList<Ride> getAllRides(int userId) {
        return (ArrayList<Ride>) (userRidesMap.containsKey(userId) ? userRidesMap.get(userId) : new ArrayList<>());
    }
}
