package org.aguinore;

import java.util.Scanner;

import static org.aguinore.StatisticsFunctions.calculateWeightedMean;
import static org.aguinore.Utils.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
        if (n < 2) {
            System.out.println(n);
            return;
        }

        int res = 0;
        int maxRes = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                res++;
            } else {
                if (res > maxRes) {
                    maxRes = res;
                }
                res = 0;
            }
            n /= 2;
            if (n == 0) {
                if (res > maxRes) {
                    maxRes = res;
                }
            }
        }

        System.out.println(maxRes);
    }
}
