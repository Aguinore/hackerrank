package org.aguinore;

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
}
