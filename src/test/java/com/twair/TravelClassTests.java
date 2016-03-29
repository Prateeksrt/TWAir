package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = FastFillingPrice.class)
public class TravelClassTests {
    private int totalSeats;
    private TravelClass economyClass;
    private Double basePrice;

    @Before
    public void setUp() throws Exception {
        totalSeats = 100;
        basePrice = 5000.0;
        economyClass = new TravelClass(ClassType.ECONOMY, totalSeats, basePrice);
    }

    @Test
    public void shouldGiveOccupiedPercentage() throws Exception {
        economyClass.book(20);
        Assert.assertEquals(20, economyClass.getOccupiedPercentage().intValue());
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfBookingCanNotBeMade() throws Exception {
        Integer numberOfSetas = 60;
        economyClass.book(numberOfSetas);
        economyClass.book(numberOfSetas);
    }

    @Test
    public void shouldReturnTrueIfBookingCanBeDone() throws Exception {
        Integer numberOfSetas = 60;
        Assert.assertTrue(economyClass.canBook(numberOfSetas));
    }

    @Test
    public void shouldReturnFalseIfBookingCanNotBeDone() throws Exception {
        Integer numberOfSetas = 110;
        Assert.assertFalse(economyClass.canBook(numberOfSetas));
    }

    /*became integration test.*/
    @Test
    public void shouldReturnExtraCostRatioForEconomyClassBasedOnSeatFillingRate() throws Exception {
        Integer numberOfSeats = 70;
        economyClass.book(numberOfSeats);
        Assert.assertEquals(0.3, economyClass.getExtraCostRatio(), 0.01);
    }
}
