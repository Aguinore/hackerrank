package org.aguinore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsFunctionsTest {

    @Test
    void calculateMean() {
        int[] arr = {1, 3};
        Assertions.assertEquals(2, StatisticsFunctions.calculateMean(arr));
    }
    @Test
    void calculateMeanOdd() {
        int[] arr = {1, 3, 5};
        assertEquals(3, StatisticsFunctions.calculateMean(arr));
    }

    @Test
    void calculateMedian() {
        int[] arr = {5, 1};
        assertEquals(3, StatisticsFunctions.calculateMedian(arr));
    }

    @Test
    void calculateMedianOdd() {
        int[] arr = {5, 1, 3};
        assertEquals(3, StatisticsFunctions.calculateMedian(arr));
    }

    @Test
    void calculateMedianSorted() {
        int[] arr = {1, 3, 5};
        assertEquals(3, StatisticsFunctions.calculateMedian(arr, true));
    }

    @Test
    void calculateMode() {
        int[] arr = {5, 1, 1};
        assertEquals(1, StatisticsFunctions.calculateMode(arr));
    }

    @Test
    void calculateModeMoreThanOne() {
        int[] arr = {5, 5, 1, 1};
        assertEquals(1, StatisticsFunctions.calculateMode(arr));
    }

    @Test
    void calculateWeightedMean() {
        int[] arr = {8, 6, 2, 1};
        int[] weights = {1, 2, 3, 4};
        assertEquals(3.0, StatisticsFunctions.calculateWeightedMean(arr, weights));
    }

    @Test
    void calculateQuartiles() {
        int[] arr = {4, 17, 7, 14, 18, 12, 3, 16, 10, 4, 4, 12};
        double[] quartiles = {4.0, 11.0, 15.0};
        assertArrayEquals(quartiles, StatisticsFunctions.calculateQuartiles(arr));
    }

    @Test
    void calculateInterquartileRange() {
        int[] arr = {4, 17, 7, 14, 18, 12, 3, 16, 10, 4, 4, 12};
        assertEquals(11.0, StatisticsFunctions.calculateInterquartileRange(arr));
    }

    @Test
    void calculateStandardDeviation() {
        int[] array = {10, 40, 30, 50, 20};
        assertEquals(14.142135623730951, StatisticsFunctions.calculateStandardDeviation(array));
    }

    @Test
    void calculateStandardDeviationLong() {
        int[] array = {6392, 51608, 71247, 14271, 48327, 50618, 67435, 47029, 61857, 22987, 64858, 99745, 75504, 85464, 60482, 30320, 11342, 48808, 66882, 40522};
        assertEquals(24245.456687800295, StatisticsFunctions.calculateStandardDeviation(array));
    }
    
    @Test
    void combinations() {
        assertEquals(3, StatisticsFunctions.combinations(3, 2));
        assertEquals(6, StatisticsFunctions.combinations(6, 1));
    }

    @Test
    void factorial() {
        assertEquals(24, StatisticsFunctions.factorial(4));
        assertEquals(2, StatisticsFunctions.factorial(2));
    }

    @Test
    void binomial() {
        assertEquals(0.24609375, StatisticsFunctions.binomial(10, 5, 0.5));
    }

    @Test
    void geometricDistribution() {
        assertTrue(0.00567 - StatisticsFunctions.geometricDistribution(5, 0.7) < 0.0000001);
        assertTrue(0.065843621 - StatisticsFunctions.geometricDistribution(5, 1.0/3) < 0.0000001);
    }
}