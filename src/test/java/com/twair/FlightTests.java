package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class FlightTests {
    private String source;
    private String dest;
    private Plane plane;
    private Calendar departure;
    private Calendar arrival;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        dest = "TestDestination";
        Map<ClassType, Integer> classMap = new HashMap<>();
        classMap.put(ClassType.ECONOMY, 30);
        plane = new Plane("type", classMap);
        departure = new GregorianCalendar(2016,3,10, 9, 10, 0);
        arrival = new GregorianCalendar(2016,3,10, 10, 10, 0);
    }

    @Test
    public void shouldHaveSourceDestination() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
        Assert.assertEquals(source, flight.getSource());
        Assert.assertEquals(dest, flight.getDestination());
    }

    @Test
    public void shouldHaveArrivalAndDeparture() throws Exception {
        Calendar departure = new GregorianCalendar(2016,4,10, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016,4,10, 11, 10, 0);
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
        Assert.assertEquals(departure, flight.getDepartureTime());
        Assert.assertEquals(arrival, flight.getArrivalTime());
    }

    @Test(expected=Exception.class)
    public void DepartureDateCannotBeGreaterOrEqualToArrivalTime() throws Exception {
        Calendar departure = new GregorianCalendar(2016,5,10, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016,4,10, 11, 10, 0);
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
    }

    @Test
    public void availableSeatsShouldBeAsPlaneSeatsByDefault() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
        Assert.assertEquals(30, flight.availableSeats(ClassType.ECONOMY));
    }

    @Test
    public void availableSeatsShouldZeorIfSetasOfThatClassIsNotAvailable() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
        Assert.assertEquals(0, flight.availableSeats(ClassType.BUSINESS));
    }

    @Test
    public void shouldReturnTrueIfThereAreSeatsOfThatClass() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
        Assert.assertTrue(flight.hasClass(ClassType.ECONOMY));
    }

    @Test
    public void shouldReturnFalseIfThereAreNoSeatsOfThatClass() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
        Assert.assertFalse(flight.hasClass(ClassType.BUSINESS));
    }

    @Test
    public void shouldHaveBasePriceForSpecifiedClass() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival);
        flight.setBasePrice(ClassType.ECONOMY, 1000);
        Assert.assertEquals(1000, flight.getBasePrice(ClassType.ECONOMY));
    }
}
