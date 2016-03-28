package com.twair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SearchForm {
    private String from;
    private String to;
    private Calendar departureDate;

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

    @Override
    public String toString() {
        return "SearchForm{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
