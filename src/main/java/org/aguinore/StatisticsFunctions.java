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
        long sumSquaredDistance = 0;
        for (int anArr : arr) {
            double squaredDistance = (anArr - mean) * (anArr - mean);
            sumSquaredDistance += squaredDistance;
        }
        return Math.sqrt(sumSquaredDistance / arr.length);
    }

    /**
     *
     * @param n total number of elements
     * @param x count of elements we want to take
     * @return number of combinations from n by x elements
     */
    public static long combinations(int n, int x) {
        if (n < 0 || x < 0 || x > n) {
            throw new IllegalArgumentException("Numbers in combinatorial function must be positive" +
                    " and we can't take more than we have");
        }
        return factorial(n) / (factorial(x) * factorial(n - x));
    }

    public static long factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("There is no factorial for negative number");
        }
        if (num < 2) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static Double binomial(int n, int x, double p) {
        if (p < 0 || p > 1) {
            throw new IllegalArgumentException("Probability must be in [0; 1]");
        }
        if (n < 0 || x < 0 || x > n) {
            throw new IllegalArgumentException("Number of trials must be positive," +
                    " number of successes must be positive and we can't take more successes than trials");
        }
        return combinations(n, x) * Math.pow(p, x) * Math.pow(1 - p, n - x);
    }
}
