package org.aguinore;

import java.util.Scanner;

import static org.aguinore.StatisticsFunctions.calculateWeightedMean;
import static org.aguinore.Utils.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = readArrayFromScanner(scanner);
        int[] weights = readArrayFromScanner(scanner, arr.length);
        scanner.close();

        double weightedMean = calculateWeightedMean(arr, weights);
        System.out.printf("%.1f%n", weightedMean);
    }
}
