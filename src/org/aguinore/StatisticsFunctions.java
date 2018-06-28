package org.aguinore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.aguinore.Utils.arrayToList;
import static org.aguinore.Utils.minKeyWithMaxCount;
import static org.aguinore.Utils.sumArray;

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
}
