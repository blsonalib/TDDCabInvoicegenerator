package com.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTimeForNormal_ShouldReturnTotalFare() {
        InVoiceService inVoiceServicer = new InVoiceService(CabSubscriptionsType.NORMAL);
        double distance = 2.0;
        int time = 5;
        double fare = inVoiceServicer.calculateTotalFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTimeForNormal_ShouldReturnMinimumFare() {
        InVoiceService inVoiceServicer = new InVoiceService(CabSubscriptionsType.NORMAL);
        double distance = 0.1;
        int time = 1;
        double fare = inVoiceServicer.calculateTotalFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRidesForNormal_ShouldReturnInvoiceSummary() {
        InVoiceService inVoiceService = new InVoiceService(CabSubscriptionsType.NORMAL);
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),

        };
        InvoiceSummary summary = inVoiceService.calculateTotalFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRidesForNormal_ShouldReturnInvoiceSummary() {
        InVoiceService inVoiceService = new InVoiceService(CabSubscriptionsType.NORMAL);
        String userId = "a@b.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        inVoiceService.addRides(userId, rides);
        InvoiceSummary summary = inVoiceService.getInvoiceSummmary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        System.out.println(expectedInvoiceSummary);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenDistanceAndTimeForPremium_ShouldReturnTotalFare() {
        InVoiceService inVoiceServicer = new InVoiceService(CabSubscriptionsType.PREMIUM);
        double distance = 2.0;
        int time = 5;
        double fare = inVoiceServicer.calculateTotalFare(distance, time);
        Assert.assertEquals(40.0, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTimeForPremium_ShouldReturnMinimumFare() {
        InVoiceService inVoiceServicer = new InVoiceService(CabSubscriptionsType.PREMIUM);
        double distance = 0.1;
        int time = 1;
        double fare = inVoiceServicer.calculateTotalFare(distance, time);
        Assert.assertEquals(20.0, fare, 0.0);
    }

    @Test
    public void givenMultipleRidesForPremium_ShouldReturnInvoiceSummary() {
        InVoiceService inVoiceService = new InVoiceService(CabSubscriptionsType.PREMIUM);
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),

        };
        InvoiceSummary summary = inVoiceService.calculateTotalFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRidesForPremium_ShouldReturnInvoiceSummary() {
        InVoiceService inVoiceService = new InVoiceService(CabSubscriptionsType.PREMIUM);
        String userId = "a@b.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        inVoiceService.addRides(userId, rides);
        InvoiceSummary summary = inVoiceService.getInvoiceSummmary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60.0);
        System.out.println(expectedInvoiceSummary);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
