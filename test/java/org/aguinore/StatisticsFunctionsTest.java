package org.aguinore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsFunctionsTest {

    @Test
    void calculateMeanTest() {
        int[] arr = {1, 3};
        Assertions.assertEquals(2, StatisticsFunctions.calculateMean(arr));
    }
    @Test
    void calculateMeanOddTest() {
        int[] arr = {1, 3, 5};
        assertEquals(3, StatisticsFunctions.calculateMean(arr));
    }

    @Test
    void calculateMedianTest() {
        int[] arr = {5, 1};
        assertEquals(3, StatisticsFunctions.calculateMedian(arr));
    }

    @Test
    void calculateMedianOddTest() {
        int[] arr = {5, 1, 3};
        assertEquals(3, StatisticsFunctions.calculateMedian(arr));
    }

    @Test
    void calculateMedianSortedTest() {
        int[] arr = {1, 3, 5};
        assertEquals(3, StatisticsFunctions.calculateMedian(arr, true));
    }

    @Test
    void calculateModeTest() {
        int[] arr = {5, 1, 1};
        assertEquals(1, StatisticsFunctions.calculateMode(arr));
    }

    @Test
    void calculateModeMoreThanOneTest() {
        int[] arr = {5, 5, 1, 1};
        assertEquals(1, StatisticsFunctions.calculateMode(arr));
    }

    @Test
    void calculateWeightedMeanTest() {
        int[] arr = {8, 6, 2, 1};
        int[] weights = {1, 2, 3, 4};
        assertEquals(3.0, StatisticsFunctions.calculateWeightedMean(arr, weights));
    }

    @Test
    void calculateQuartilesTest() {
        int[] arr = {4, 17, 7, 14, 18, 12, 3, 16, 10, 4, 4, 12};
        double[] quartiles = {4.0, 11.0, 15.0};
        assertArrayEquals(quartiles, StatisticsFunctions.calculateQuartiles(arr));
    }

    @Test
    void calculateInterquartileRangeTest() {
        int[] arr = {4, 17, 7, 14, 18, 12, 3, 16, 10, 4, 4, 12};
        assertEquals(11.0, StatisticsFunctions.calculateInterquartileRange(arr));
    }
}