package com.twair;

import org.junit.Assert;
import org.junit.Test;

public class FastFillingPriceTests {
    @Test
    public void shouldReturnExtratCostIfTheSeatsAreFilledAboveSomePercentage() throws Exception {
        double[][] percentageBreak = new double[][]{
                { 0, 0 },
                { 40, 0.3 },
                { 90, 0.5 }
        };
        double occupiedPercentage = 41.0;
        FastFillingPrice fastFillingPrice = new FastFillingPrice(percentageBreak);
        Assert.assertEquals(0.3, fastFillingPrice.basePriceRatio(occupiedPercentage), 0.01);

    }
}
