package org.aguinore.coursera;

import org.aguinore.math.MathFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompetitiveProgramming {

    /**
     * Given two integers x and y, construct an infinite sequence of integers A = {a 0 ,a 1 ,a 2 ,...} as
     * follows: a 0 = 0 and for every i ≥ 1, a 2i−1 = a 2i−2 + x and a 2i = a 2i−1 − y.
     * Given three integers x, y and z, find the index of the first occurrence of z in A or report that z
     * does not appear in A.
     * For example, if x = 2, y = 1 and z = 3, then A = (0,2,1,3,2,4,3,...) and the answer is 3 (a 3 = 3
     * and this is the first occurrence of 3 in A). If x = 2, y = 0 and z = 3, then A = (0,2,2,4,4,6,6,...)
     * and the answer is −1 (there is no occurrence of 3 in A).
     * Input
     * Three integers x, y and z (0 ≤ x,y,z ≤ 1000) separated by spaces.
     * Output
     * The first position of z in A or −1, if there is no occurrence of z in A.
     */
    public static int additionAndSubtraction(int x, int y, int z) {
        int[] a = new int[3];
        int i = 0;
        while (a[2] <= 1000 && a[2] - y <= z)  {
            a[1] = a[0] + x;
            if (a[1] == z) {
                return 2 * i + 1;
            }
            a[2] = a[1] - y;
            if (a[2] == z) {
                return 2 * i + 2;
            }
            a[0] = a[2];
            i++;
        }
        return -1;
    }

    /**
     * Let A[1..n] be an array of integers. Output the same array without its maximum element. If there
     * are several maximum elements, get rid of the third. It is guaranteed that the input array A has
     * either a unique maximum element or at least three maximum elements.
     * Input
     * The first line contains an integer n (2 ≤ n ≤ 100), the length of the array. The second line
     * contains integers A[1],A[2],...,A[n] (1 ≤ A[i] ≤ 100, 1 ≤ i ≤ n).
     * Output
     * Output n − 1 integers separated by spaces.
     */
    public static Integer[] eraseMaximum(int[] arr) {
        int max = MathFunctions.maximum(arr);
        int count = 0;
        for (int num: arr) {
            if (num == max) {
                count++;
            }
        }
        List<Integer> result = new ArrayList<>();
        int skipped = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != max) {
                result.add(arr[i]);
            } else if (count > 3 && skipped != 2) {
                result.add(arr[i]);
                skipped++;
            } else {
                skipped++; //skip max value, all next must be added
            }
        }
        return result.toArray(new Integer[arr.length-1]);
    }

    /**
     * Given a large non-negative integer x, find the number of decimal digits in x + 1.
     * Input
     * A non-negative integer x (0 ≤ x ≤ 10^1000000 ) with no leading zeroes.
     * Output
     * The number of decimal digits in x + 1.
     */
    public static int increment(String longNum) {
        for (int i = 0; i < longNum.length(); i++) {
            if (longNum.charAt(i) != '9') {
                return longNum.length();
            }
        }
        return longNum.length() + 1;
    }

    /**
     * The deck of 52 French playing cards is the most common deck of playing cards used today. It
     * includes thirteen ranks of each of the four French suits: clubs (C), diamonds (D), hearts (H), and
     * spades (S). Each suit includes an ace (A), a king (K), a queen (Q), and a jack (J), each depicted
     * with a symbol of its suit; and ranks two (2) through ten (T), with each card depicting that many
     * symbols (pips) of its suit.
     * A straight flush is a poker hand containing five cards of sequential rank, all of the same suit,
     * such as QH JH TH 9H 8H (a “queen-high straight flush”). As part of a straight flush, an ace (A) can
     * rank either above a king or below a two. So an ace can rank either high (e.g., AH KH QH JH TH is an
     * ace-high straight flush) or low (e.g., 5D 4D 3D 2D AD is a five-high straight flush), but cannot rank
     * both high and low in the same hand (e.g. QS KS AS 2S 3S is not a straight flush). Thus, there are
     * 40 possible straight flush hands when using a standard 52-card deck.
     * Given 5 different cards, check whether they constitute a straight flush.
     * Input
     * Five different cards separated by spaces. Each card is specified by two symbols: the first one is
     * a rank and the second is a suit. Suites are marked with letters C, D, H, and S. Ranks are marked
     * with symbols 2, 3, ..., 9, T, J, Q, K, and A.
     * Output
     * Output YES, if the given cards form a straight flush, otherwise output NO.
     */
    public static boolean straightFlush(String cards) {
        String[] cardsArray = cards.split(" ");
        char suit = cardsArray[0].charAt(1);
        int[] ranks = new int[5];
        for (int i = 0; i < 5; i++) {
            if (cardsArray[i].charAt(1) != suit) {
                return false;
            }
            int rank = -1;
            switch (cardsArray[i].charAt(0)) {
                case 'A':
                    rank = 1;
                    break;
                case 'T':
                    rank = 10;
                    break;
                case 'J':
                    rank = 11;
                    break;
                case 'Q':
                    rank = 12;
                    break;
                case 'K':
                    rank = 13;
                    break;
                default:
                    rank = Integer.parseInt(cardsArray[i].charAt(0) + "");
            }
            ranks[i] = rank;
        }
        Arrays.sort(ranks);
        if (ranks[0] == 1 && ranks[1] == 10 && ranks[2] == 11 && ranks[3] == 12 && ranks[4] == 13) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (ranks[i + 1] != ranks[i] + 1) {
                return false;
            }
        }
        return true;
    }
}
