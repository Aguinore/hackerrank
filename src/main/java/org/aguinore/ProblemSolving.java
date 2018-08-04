package org.aguinore;

public class ProblemSolving {
    static String appendAndDelete(String s, String t, int k) {
        if (s.length() - t.length() > k) {//difference in length is more than possible changes
            return "No";
        }
        if (s.length() - t.length() == k && !s.startsWith(t)) { //difference in length is equal to possible changes, so strings must be equal
            return "No";
        }
        if (s.length() - t.length() == k && s.startsWith(t)) { //difference in length is equal to possible changes, so strings must be equal
            return "Yes";
        }
        if (k >= (s.length() + t.length())) { //strings are the same, and we can erase one and create another from scratch
            return "Yes";
        }
        if (s.equals(t)) {
            return "Yes";
        }
        int equalPartLength = 0;
        for (int i = 0; i < s.length() && i < t.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                equalPartLength++;
            } else {
                break;
            }
        }
        int sDifferLength = s.length() - equalPartLength;
        int tDifferLength = t.length() - equalPartLength;
        if (Math.abs(sDifferLength + tDifferLength) == k) { // we can remove some symbols from first line and then add some to get desired
            return "Yes";
        }
        if ((k - sDifferLength - tDifferLength) > 0 && (k - sDifferLength - tDifferLength) % 2 == 0) {
            return "Yes";
        }
        return "No";
    }
}
