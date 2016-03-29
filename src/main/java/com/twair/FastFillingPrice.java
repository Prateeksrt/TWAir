package com.twair;

public class FastFillingPrice {
    private double[][] percentageBreak;

    public FastFillingPrice(double[][] percentageBreak) {
        this.percentageBreak = percentageBreak;
    }

    public double basePriceRatio(double occupiedPercentage) {
        double ratio = 0;
        for(int i=0; i < percentageBreak.length; i++) {
            if(percentageBreak[i][0] < occupiedPercentage) {
                ratio = percentageBreak[i][1];
            }
        }
        return ratio;
    }
}
