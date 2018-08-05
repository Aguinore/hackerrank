package org.aguinore.math;

import java.util.ArrayList;
import java.util.List;

public class MathFunctions {

    public static boolean isPrimal(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Cannot check if negative n is primal");
        }
        if (n == 1) {
            return false;
        }
        if (n < 4) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long fibonacci(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot return negative Fibonacci number");
        }
        if (num < 2) {
            return num;
        }
        long previous = 1;
        long current = 1;
        for (int i = 2; i < num; i++) {
            long newCurrent = previous + current;
            previous = current;
            current = newCurrent;
        }
        return current;
    }

    public static List<Integer> getAllMultiples(int[] nums, int maxMultiple) {
        List<Integer> multiples = new ArrayList<>();
        for (int i = 1; i <= maxMultiple; i++) {
            boolean isDiv = true;
            for (int num : nums) {
                if (i % num != 0) {
                    isDiv = false;
                    break;
                }
            }
            if (isDiv) {
                multiples.add(i);
            }
        }
        return multiples;
    }

    public static String binaryInt(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            res.append(n % 2);
            n /= 2;
        }
        return res.reverse().toString();
    }

    public static int minimum(int... nums) {
        int result = Integer.MAX_VALUE;
        for(int num: nums) {
            if (num < result) {
                result = num;
            }
        }
        return result;
    }
}
