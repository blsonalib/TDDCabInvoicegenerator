package com.cabinvoicegenerator;

import java.awt.*;
import java.util.List;

public class InVoiceService {

    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double MINIMUM_FARE = 5;
    private RideRepository rideRepository = new RideRepository();

    public double calculateTotalFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateTotalFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateTotalFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides (String userId, Ride[] rides) {
        rideRepository.addRides(userId,rides);

    }

    public InvoiceSummary getInvoiceSummmary(String userId) {
      Ride[] rides=rideRepository.getRides(userId);
        return this.calculateTotalFare(rides);
    }
}
