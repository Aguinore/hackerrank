package org.aguinore;

import java.util.*;

public class CrackInterview {
    public static int[] rotLeft(int[] a, int d) {
        int actualShift = d % a.length;
        int i = a.length - 1 - actualShift;
        int tempValue = a[i];
        System.out.println("before i=" + i + ", tempValue=" + tempValue);
        boolean first = true;
        while(first || i != a.length - 1 - actualShift) {
            a[i] = a[(i + actualShift) % a.length];
            i = (i + a.length - actualShift) % a.length;
            a[Math.abs(i - (a.length - actualShift)) % a.length] = tempValue;
            tempValue = a[i];
            System.out.println(Arrays.toString(a) + " and i = " + i);
            first = false;
        }
        return a;
    }
}
