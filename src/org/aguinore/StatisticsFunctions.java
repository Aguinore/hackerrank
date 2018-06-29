package org.aguinore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.aguinore.Utils.*;

public class StatisticsFunctions {

    public static double calculateMean(int[] arr) {
        double sum = sumArray(arr);
        return (sum / arr.length);
    }

    public static double calculateMedian(int[] arr) {
        List<Integer> list = arrayToList(arr);
        list.sort(null);
        double median;
        if (list.size() % 2 == 1) {
            median = list.get(list.size() / 2);
        } else {
            int left = list.get(list.size() / 2 - 1);
            int right = list.get(list.size() / 2);
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
        quartiles[1] = calculateMedian(arr);
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
        System.out.println("rightArr = " + Arrays.toString(rightArr));
        System.out.println("leftArr = " + Arrays.toString(leftArr));
        quartiles[0] = calculateMedian(leftArr);
        quartiles[2] = calculateMedian(rightArr);
        return quartiles;
    }
}
