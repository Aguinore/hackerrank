package org.aguinore.coursera;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompetitiveProgrammingTest {

    @Test
    void additionAndSubtraction() {
        assertEquals(3, CompetitiveProgramming.additionAndSubtraction(2, 1, 3));
        assertEquals(11, CompetitiveProgramming.additionAndSubtraction(10, 7, 25));
        assertEquals(-1, CompetitiveProgramming.additionAndSubtraction(2, 0, 3));
    }

    @Test
    void eraseMaximum() {
        int[] arr = {1, 3, 2};
        Integer[] expected = {1, 2};
        assertArrayEquals(expected, CompetitiveProgramming.eraseMaximum(arr));
        int[] arr1 = {4, 1, 4, 2, 4, 3, 4};
        Integer[] expected1 = {4, 1, 4, 2, 3, 4};
        assertArrayEquals(expected1, CompetitiveProgramming.eraseMaximum(arr1));
    }

    @Test
    void increment() {
        assertEquals(1, CompetitiveProgramming.increment("1"));
        assertEquals(2, CompetitiveProgramming.increment("9"));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append("1");
        }
        String longNum = stringBuilder.toString();
        assertEquals(1000000, CompetitiveProgramming.increment(longNum));
        stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append("9");
        }
        longNum = stringBuilder.toString();
        assertEquals(1000001, CompetitiveProgramming.increment(longNum));
    }

    @Test
    void straightFlush() {
        assertTrue(CompetitiveProgramming.straightFlush("2D 5D 3D 4D 6D"));
        assertTrue(CompetitiveProgramming.straightFlush("2D 5D AD 4D 3D"));
        assertFalse(CompetitiveProgramming.straightFlush("2D 3D AD KD QD"));
        assertFalse(CompetitiveProgramming.straightFlush("AD KH QH JS TC"));
        assertTrue(CompetitiveProgramming.straightFlush("AH KH QH JH TH"));
        assertFalse(CompetitiveProgramming.straightFlush("AH KH QH 9H TH"));
    }
}