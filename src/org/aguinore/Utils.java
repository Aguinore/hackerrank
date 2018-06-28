package org.aguinore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    public static int[] readArrayFromScanner() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static double sumArray(int[] arr) {
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i: arr) {
            list.add(i);
        }
        return list;
    }
}
