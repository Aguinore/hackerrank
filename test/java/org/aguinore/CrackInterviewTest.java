package org.aguinore;

import org.junit.jupiter.api.Test;

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
}