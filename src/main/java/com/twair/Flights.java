package com.twair;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Flights {

    List<Flight> flightList;

    public Flights(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public Flights() {
        this.flightList = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public Flights searchByLocation(String source, String destination) {
        if(source == null || source.isEmpty() || destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("source cannot be null");
        }
        List<Flight> matchingFlights = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            if (flight.getSource().equals(source) && flight.getDestination().equals(destination)) {
                matchingFlights.add(flight);
            }
        }
        return new Flights(matchingFlights);
    }

    public Flights searchByDeparture(Calendar departureDate) {
        if(departureDate == null) {
            return this;
        }
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flightList) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            if (departureDate != null) {
                if (dateFormat.format(flight.getDepartureTime().getTime()).equals(dateFormat.format(departureDate.getTime()))) {
                    matchingFlights.add(flight);
                }
            }
        }
        return new Flights(matchingFlights);
    }
}
