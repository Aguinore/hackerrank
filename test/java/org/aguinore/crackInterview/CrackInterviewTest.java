package org.aguinore.crackInterview;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CrackInterviewTest {

    @Test
    void rotLeftBruteforce() {
        int[] array = {1, 2, 3, 4, 5};
        int[] result = {4, 5, 1, 2, 3};

        assertArrayEquals(result, CrackInterview.rotLeftBruteforce(array, 3));
    }

    @Test
    void makeAnagram() {
        String a = "abcde";
        String b = "cdefg";
        assertEquals(4, CrackInterview.makeAnagram(a, b));
    }

    @Test
    void makeAnagramAnother() {
        String a = "cde";
        String b = "abc";
        assertEquals(4, CrackInterview.makeAnagram(a, b));
    }

    @Test
    void makeAnagramRepetitions() {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        assertEquals(30, CrackInterview.makeAnagram(a, b));
    }

    @Test
    void checkMagazineFalse() {
        String[] magazine = {"two", "times", "three", "is", "not", "four"};
        String[] note = {"two", "times", "two", "is", "four"};
        assertFalse(CrackInterview.checkMagazine(magazine, note));
    }

    @Test
    void checkMagazine() {
        String[] magazine = {"give", "me", "one", "grand", "today", "night"};
        String[] note = {"give", "one", "grand", "today"};
        assertTrue(CrackInterview.checkMagazine(magazine, note));
    }

    @Test
    void hasListCyclesEmpty() {
        CrackInterview.Node node = new CrackInterview.Node();
        node.next = null;
        assertFalse(CrackInterview.hasListCycles(node));
    }

    @Test
    void hasListCyclesFalse() {
        CrackInterview.Node node = new CrackInterview.Node();
        node.next = new CrackInterview.Node();
        assertFalse(CrackInterview.hasListCycles(node));
    }

    @Test
    void hasListCyclesTrue() {
        CrackInterview.Node node = new CrackInterview.Node();
        node.next = node;
        assertTrue(CrackInterview.hasListCycles(node));
    }

    @Test
    void ifBracketsBalanced() {
        String brackets = "{[()]}";
        assertTrue(CrackInterview.ifBracketsBalanced(brackets));
    }

    @Test
    void ifBracketsBalancedEmpty() {
        String brackets = "";
        assertTrue(CrackInterview.ifBracketsBalanced(brackets));
    }

    @Test
    void ifBracketsBalancedLong() throws FileNotFoundException {
        Scanner scanner = new Scanner(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("crackInterview/brackets"));
        Scanner anotherScanner = new Scanner(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("crackInterview/brackets_res"));
        while (scanner.hasNext()) {
            String brackets = scanner.nextLine();
            String res = anotherScanner.nextLine();
            if (res.equals("YES")) {
                assertTrue(CrackInterview.ifBracketsBalanced(brackets));
            } else {
                assertFalse(CrackInterview.ifBracketsBalanced(brackets));
            }
        }
    }

    @Test
    void ifBracketsBalancedFalse() {
        String brackets = "{[(])}";
        assertFalse(CrackInterview.ifBracketsBalanced(brackets));
    }

    @Test
    void ifBracketsBalancedMalformed() {
        String brackets = "{[(0]}";
        assertFalse(CrackInterview.ifBracketsBalanced(brackets));
    }

    @Test
    void findSubarrayWithSumEasy() {
        int[] arr = {3, 5, -1, 2, 4, -3, 7};
        int[] expected = {1, 3};
        assertArrayEquals(expected, CrackInterview.findSubarrayWithSum(arr, 6));
    }

    @Test
    void findSubarrayWithSum() {
        int[] arr = {3, 5, -1, 2, 4, -3, 7};
        int[] expected = {2, 3};
        assertArrayEquals(expected, CrackInterview.findSubarrayWithSum(arr, 1));
    }

    @Test
    void findSubarrayWithSum1() {
        int[] arr = {10, 70, -30, 10};
        int[] expected = {1, 2};
        assertArrayEquals(expected, CrackInterview.findSubarrayWithSum(arr, 40));
    }

    @Test
    @Disabled
    void findSubarrayWithSum2() {
        int[] arr = {-100, 10, 30, -100};
        int[] expected = {1, 2};
        assertArrayEquals(expected, CrackInterview.findSubarrayWithSum(arr, 40));
    }
}