package org.aguinore;

import java.util.*;

import static org.aguinore.Utils.arrayToList;
import static org.aguinore.Utils.readArrayFromScanner;
import static org.aguinore.Utils.sumArray;

public class Solution {
    public static void main(String[] args) {
        int[] arr = readArrayFromScanner();

        System.out.printf("%.1f%n", calculateMean(arr));
        System.out.printf("%.1f%n", calculateMedian(arr));
        calculateMode(arr);
    }

    private static double calculateMean(int[] arr) {
        double sum = sumArray(arr);
        return (sum / arr.length);
    }

    private static double calculateMedian(int[] arr) {
        List<Integer> list = arrayToList(arr);
        list.sort(null);
        System.out.println(list);
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

    private static void calculateMode(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i: arr) {
            if (counts.containsKey(i)) {
                counts.put(i, counts.get(i) + 1);
            } else {
                counts.put(i, 1);
            }
        }

    }
}
