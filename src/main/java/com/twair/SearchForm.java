package com.twair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SearchForm {
    private String from;
    private String to;
    private Calendar departureDate;
    private String number;
    private Integer numberSeats;

    public Calendar getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDateString) throws ParseException {
        if(departureDateString.isEmpty()) {
            this.departureDate = null;
        }else{
            Calendar departureDate = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            departureDate.setTime(sdf.parse(departureDateString));
            this.departureDate = departureDate;
        }
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
        if(numberSeats == null) {
            this.numberSeats = 0;
        }else{
            this.numberSeats = numberSeats;
        }
    }

    @Override
    public String toString() {
        return "SearchForm{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", departureDate=" + departureDate +
                ", numberSeats=" + numberSeats +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
