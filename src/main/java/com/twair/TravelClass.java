package com.twair;

public class TravelClass {

    private final Double basePrice;
    private ClassType classType;
    private Integer totalSeats;
    private Integer occupiedSeats;
    private FastFillingPrice fastFillingPrice;

    public TravelClass(ClassType classType, Integer totalSeats, Double basePrice) {
        this.classType = classType;
        this.totalSeats = totalSeats;
        this.occupiedSeats = 0;
        this.basePrice = basePrice;
        if(classType == ClassType.ECONOMY) {
            double[][] percentageBreak = new double[][]{
                    { 0, 0 },
                    { 40, 0.3 },
                    { 90, 0.6 }
            };
            fastFillingPrice = new FastFillingPrice(percentageBreak);
        }
    }

    public void book(int numberOfSeats) throws Exception {
        if(canBook(numberOfSeats) == false) {
            throw new Exception("Booking can not be made");
        }
        occupiedSeats += numberOfSeats;
    }

    public Float getOccupiedPercentage() {
        return ((float)occupiedSeats/totalSeats)*100;
    }

    public boolean canBook(Integer numberOfSetas) {
        if(occupiedSeats + numberOfSetas > totalSeats) {
            return false;
        }
        return true;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public double getExtraCostRatio() {
        if(fastFillingPrice != null) {
            return fastFillingPrice.basePriceRatio(getOccupiedPercentage());
        }
        return 0.0;
    }
}
