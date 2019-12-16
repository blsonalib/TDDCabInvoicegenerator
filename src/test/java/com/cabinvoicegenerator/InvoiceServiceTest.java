package com.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

    InVoiceService inVoiceServicer = new InVoiceService();

    @Before
    public void setUp() throws Exception {
        InVoiceService inVoiceServicer = new InVoiceService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InVoiceService inVoiceServicer = new InVoiceService();
        double distance = 2.0;
        int time = 5;
        double fare = inVoiceServicer .calculateTotalFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        InVoiceService inVoiceServicer = new InVoiceService();
        double distance = 0.1;
        int time = 1;
        double fare = inVoiceServicer .calculateTotalFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InVoiceService inVoiceService = new InVoiceService();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = inVoiceService.calculateTotalFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        InVoiceService inVoiceService = new InVoiceService();
        String userId = "a@b.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        inVoiceService.addRides(userId, rides);
        InvoiceSummary summary = inVoiceService.getInvoiceSummmary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
