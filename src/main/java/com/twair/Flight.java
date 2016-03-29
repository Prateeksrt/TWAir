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
    private Map<ClassType, Integer> availableSeats = new HashMap<>();
    private Map<ClassType, Integer> basePriceMap = new HashMap<>();
    private String number;

    public Flight(String number, String source, String destination, Plane plane, Calendar departure, Calendar arrival) throws Exception {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.availableSeats.putAll(plane.getClassType());
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

    public void setBasePrice(ClassType classType, int basePrice) {
        basePriceMap.put(classType, basePrice);
    }

    public int getBasePrice(ClassType classType) {
        return basePriceMap.get(classType);
    }

    private void setScheduleTime(Calendar departureTime, Calendar arrivalTime) throws Exception {
        if(departureTime.after(arrivalTime)) {
            throw new Exception("departure time cannot be greater than arrival time");
        }
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public int availableSeats(ClassType classType) {
        if( availableSeats.containsKey(classType) ) {
            return availableSeats.get(classType);
        }
        return 0;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean hasClass(ClassType classType) {
        return availableSeats.containsKey(classType);
    }
}
