package org.aguinore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.aguinore.Utils.*;

public class StatisticsFunctions {

    public static double calculateMean(int[] arr) {
        double sum = sumArray(arr);
        return (sum / arr.length);
    }

    public static double calculateMedian(int[] arr) {
        return calculateMedian(arr, false);
    }

    public static double calculateMedian(int[] arr, boolean sorted) {
        if (!sorted) {
            Arrays.sort(arr);
        }
        double median;
        if (arr.length % 2 == 1) {
            median = arr[arr.length / 2];
        } else {
            int left = arr[arr.length / 2 - 1];
            int right = arr[arr.length / 2];
            median = (left + right) / 2.0;
        }
        return median;
    }

    public static int calculateMode(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i: arr) {
            if (counts.containsKey(i)) {
                counts.put(i, counts.get(i) + 1);
            } else {
                counts.put(i, 1);
            }
        }
        return minKeyWithMaxCount(counts);
    }

    public static double calculateWeightedMean(int[] arr, int[] weights) {
        double weightsSum = 0.0;
        int weightedArr = 0;
        for (int i = 0; i < arr.length; i++) {
            weightsSum += weights[i];
            weightedArr += arr[i] * weights[i];
        }
        return weightedArr / weightsSum;
    }

    public static double[] calculateQuartiles(int[] arr){
        double[] quartiles = new double[3];
        Arrays.sort(arr);
        quartiles[1] = calculateMedian(arr,true);
        int halfLength;
        int[] leftArr;
        int[] rightArr;
        if (arr.length % 2 == 1) {
            halfLength = (arr.length - 1) / 2;
            leftArr = new int[halfLength];
            rightArr = new int[halfLength];
            System.arraycopy(arr, 0, leftArr, 0, halfLength);
            System.arraycopy(arr, halfLength + 1, rightArr, 0, halfLength);
        } else {
            halfLength = arr.length / 2;
            leftArr = new int[halfLength];
            rightArr = new int[halfLength];
            System.arraycopy(arr, 0, leftArr, 0, halfLength);
            System.arraycopy(arr, halfLength, rightArr, 0, halfLength);
        }
        quartiles[0] = calculateMedian(leftArr, true);
        quartiles[2] = calculateMedian(rightArr, true);
        return quartiles;
    }

    public static double calculateInterquartileRange(int[] arr) {
        double[] quartiles = calculateQuartiles(arr);
        return quartiles[2] - quartiles[0];
    }

    public static double calculateStandardDeviation(int[] arr) {
        double mean = calculateMean(arr);
        int sumSquaredDistance = 0;
        for (int i = 0; i < arr.length; i++) {
            sumSquaredDistance += (arr[i] - mean) * (arr[i] - mean);
        }
        return Math.sqrt(sumSquaredDistance / arr.length);
    }
}
