package com.twair;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Flight {
    private String source;
    private String destination;
    private Plane plane;
    private Calendar departureTime;
    private Calendar arrivalTime;
    private String number;
    private Map<ClassType, TravelClass> travelClasses = new HashMap<>();

    public Flight(String number, String source, String destination, Plane plane, Calendar departure, Calendar arrival, Map<ClassType, Double> basePriceMap) throws Exception {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        for (ClassType key : plane.getClassType().keySet()) {
            TravelClass travelClass = new TravelClass(key, plane.getClassType().get(key), basePriceMap.get(key));
            travelClasses.put(key, travelClass);
        }
        setScheduleTime(departure, arrival);
        this.number = number;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }


    public Calendar getDepartureTime() {
        return departureTime;
    }

    public Calendar getArrivalTime() {
        return arrivalTime;
    }

    public Double getBasePrice(ClassType classType) {
        if( travelClasses.containsKey(classType) ) {
            return travelClasses.get(classType).getBasePrice();
        }
        return 0.0;
    }

    private void setScheduleTime(Calendar departureTime, Calendar arrivalTime) throws Exception {
        if(departureTime.after(arrivalTime)) {
            throw new Exception("departure time cannot be greater than arrival time");
        }
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getNumber() {
        return number;
    }

    public boolean hasClass(ClassType classType) {
        return travelClasses.containsKey(classType);
    }

    public boolean canBook(ClassType classType, Integer numberOfSeats) {
        if(travelClasses.containsKey(classType)) {
            return travelClasses.get(classType).canBook(numberOfSeats);
        }
        return false;
    }
}
