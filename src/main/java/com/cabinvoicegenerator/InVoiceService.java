package com.cabinvoicegenerator;

public class InVoiceService {

    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double MINIMUM_FARE = 5;
    private static final int PREMIUM_COST_PER_TIME = 2;
    private static final double PREMIUM_MINIMUM_COST_PER_KM = 15;
    private static final double PREMIUM_MINIMUM_FARE = 20;

    public InVoiceService(CabSubscriptionsType cabSubscriptions) {
        this.cabSubscriptions = cabSubscriptions;
    }

    private RideRepository rideRepository = new RideRepository();
    CabSubscriptionsType cabSubscriptions;

    public double calculateTotalFare(double distance, int time) {
        if (CabSubscriptionsType.NORMAL.equals(cabSubscriptions)) {
            double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
            return Math.max(totalFare, MINIMUM_FARE);
        } else if (CabSubscriptionsType.PREMIUM.equals(cabSubscriptions)) {
            double totalFare = distance * PREMIUM_MINIMUM_COST_PER_KM + time * PREMIUM_COST_PER_TIME;
            return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
        }
        return 0.0;
    }

    public InvoiceSummary calculateTotalFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateTotalFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) throws CabServiceException {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummmary(String userId) throws CabServiceException {
        Ride[] rides = rideRepository.getRides(userId);
        return this.calculateTotalFare(rides);
    }
}

