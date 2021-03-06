package org.aguinore;

import org.aguinore.math.MathFunctions;

import java.util.*;

public class Utils {

    public static int[] readArrayFromScanner() {
        Scanner scanner = new Scanner(System.in);
        return readArrayFromScanner(scanner);
    }

    public static int[] readArrayFromScanner(Scanner scanner) {
        int num = scanner.nextInt();
        return readArrayFromScanner(scanner, num);
    }

    public static int[] readArrayFromScanner(Scanner scanner, int arraySize) {
        int[] arr = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static long sumArray(int[] arr) {
        long sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static int findCharInArray(char[] arr, char num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i: arr) {
            list.add(i);
        }
        return list;
    }

    public static int[] getArrayWithCounts(int[] arr, int[] counts) {
        int weightSum = (int) sumArray(counts);

        int[] array = new int[weightSum];

        int i = 0;
        int counter = 0;
        while (i < counts.length) {
            for (int j = 0; j < counts[i]; j++) {
                array[counter] = arr[i];
                counter++;
            }
            i++;
        }
        return array;
    }

    public static <K extends Comparable<K>, V extends Comparable<V>> K minKeyWithMaxCount(Map<K, V> map) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("map must contain at least one entry");
        }
        K firstKey = map.keySet().iterator().next();
        if (map.size() == 1) {
            return firstKey;
        }
        V maxCount = map.get(firstKey);
        for (Map.Entry<K, V> entry: map.entrySet()) {
               if (entry.getValue().compareTo(maxCount) > 0) {
                   maxCount = entry.getValue();
               }
        }
        K minKeyWithMaxCount = firstKey;
        for (Map.Entry<K, V> entry: map.entrySet()) {
            if (map.get(entry.getKey()).equals(maxCount)) {
                K appropriateKey = entry.getKey();
                if (appropriateKey.compareTo(minKeyWithMaxCount) < 0) {
                    minKeyWithMaxCount = appropriateKey;
                }
            }
        }
        return minKeyWithMaxCount;
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int levenshteinDistance(String str1, String str2) {
        int[][] distances = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            distances[i][0] = i;
        }
        for (int i = 0; i < str2.length() + 1; i++) {
            distances[0][i] = i;
        }

        //TODO reduce space complexity to min(str1.length, str2.length).
        //Have to store only current and previous columns (rows)  
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                int diff = str1.charAt(i - 1) == str2.charAt(j - 1) ? 0: 1;
                distances[i][j] = MathFunctions.minimum(distances[i - 1][j] + 1, distances[i][j - 1] + 1, distances[i - 1][j - 1] + diff);
            }
        }
        return distances[str1.length()][str2.length()];
    }

    public static int[] knapsackWithRepetitions(int maxWeight, int[] weights, int[] values) {
        int[] result = new int[maxWeight + 1];

        for (int u = 1; u < maxWeight + 1; u++) {
            for (int i = 0; i < weights.length; i++) {
                if (weights[i] <= u) {
                    result[u] = Math.max(result[u], result[u - weights[i]] + values[i]);
                }
            }
        }

        return result;
    }

    public static int knapsackWithoutRepetitions(int maxWeight, int[] weights, int[] values) {
        int[][] result = new int[maxWeight + 1][weights.length + 1];

        for (int u = 0; u < maxWeight + 1; u++) {
            result[u][0] = 0;
        }

        for (int i = 1; i < weights.length + 1; i++) {
            for (int u = 0; u < maxWeight + 1; u++) {
                result[u][i] = result[u][i - 1];
                if (weights[i - 1] <= u) {
                    result[u][i] = Math.max(result[u][i], result[u - weights[i - 1]][i - 1] + values[i - 1]);
                }
            }
        }

        return result[maxWeight][weights.length];
    }
}
