package org.aguinore;

import java.util.Arrays;

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

    /**
     *
     * @return an integer representing the minimum total characters that must be deleted to make the strings anagrams.
     */
    public static int makeAnagram(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        Arrays.sort(aChars);
        Arrays.sort(bChars);

        if (a.charAt(0) > b.charAt(0)) {
            char[] chars = aChars;
            aChars = bChars;
            bChars = chars;
        }

        int result = 0;
        for (int i = 0; i < bChars.length; i++) {
            int aIndex = Utils.findCharInArray(aChars, bChars[i]);
            if (aIndex >= 0) {
                aChars[aIndex] = '4';
                bChars[i] = '4';
            } else {
                result++;
            }
        }
        for (int i = 0; i < aChars.length; i++) {
            int bIndex = Utils.findCharInArray(bChars, aChars[i]);
            if (bIndex >= 0) {
                bChars[bIndex] = '6';
            } else {
                result++;
            }
        }
        return result;
    }
}
