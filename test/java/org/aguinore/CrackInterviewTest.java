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
}