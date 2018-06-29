package org.aguinore;

public class CrackInterview {
    public static int[] rotLeftBruteforce(int[] a, int d) {
        int actualShift = d % a.length;
        for (int i = 0; i < actualShift; i++) {
            int tempValue = a[0];
            for (int j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1];
            }
            a[a.length - 1] = tempValue;
        }
        return a;
    }
}
