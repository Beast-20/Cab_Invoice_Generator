package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {
    Cabinvoicegenerator cabInvoiceGenerator = new Cabinvoicegenerator();

    @Test
    public void testCalculateFare() {
        double fare = cabInvoiceGenerator.calculateFare(15, 25); // Updated values
        assertEquals(175, fare, 0.001);
    }

    @Test
    public void testMinimumFare() {
        double fare = cabInvoiceGenerator.calculateFare(0, 0); // Updated values
        assertEquals(5, fare, 0.001);
    }

    @Test
    public void testMultipleRideFare() {
        Ride[] rides = { new Ride(1, 8, 18, Type.ECONOMY), // Updated values
                new Ride(1, 15, 30, Type.ECONOMY), // Updated values
                new Ride(1, 10, 20, Type.ECONOMY) };
        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        assertEquals(398, totalFare, 0.001);
    }

    @Test
    public void testInvoice() {
        Ride[] rides = { new Ride(1, 8, 18, Type.ECONOMY), // Updated values
                new Ride(1, 15, 30, Type.ECONOMY), // Updated values
                new Ride(1, 10, 20, Type.ECONOMY) };
        invoice invoice = cabInvoiceGenerator.generateInvoice(rides);
        assertEquals(3, invoice.getNumberOfRides());
        assertEquals(398, invoice.getTotalFare(), 0.001);
        assertEquals(132.66666666666666, invoice.getAverageFare(), 0.001);
    }

    @Test
    public void testInvoiceForUser() {
        // creating some new rides
        new Ride(1, 8, 18, Type.ECONOMY); // Updated values
        new Ride(1, 15, 30, Type.ECONOMY); // Updated values
        new Ride(2, 10, 25, Type.ECONOMY); // Updated values

        invoice invoice = cabInvoiceGenerator.generateInvoiceForUser(1);
        assertEquals(2, invoice.getNumberOfRides());
        assertEquals(278, invoice.getTotalFare(), 0.001); // Updated values
        assertEquals(139, invoice.getAverageFare(), 0.001); // Updated values
    }

    @Test
    public void testRidesWithType() {
        Ride[] rides = { new Ride(1, 8, 18, Type.ECONOMY), // Updated values
                new Ride(1, 15, 30, Type.ECONOMY), // Updated values
                new Ride(1, 10, 20, Type.DELUXE) };
        invoice invoice = cabInvoiceGenerator.generateInvoice(rides);
        assertEquals(3, invoice.getNumberOfRides());
        assertEquals(468, invoice.getTotalFare(), 0.001);
        assertEquals(156, invoice.getAverageFare(), 0.001);
    }
}
