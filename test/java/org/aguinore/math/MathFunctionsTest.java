package org.aguinore.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathFunctionsTest {

    @Test
    void primality() {
        for (int i = 1; i <= 29; i++) {
            assertFalse(MathFunctions.isPrimal(i * i));
        }
        assertTrue(MathFunctions.isPrimal(907));
        assertFalse(MathFunctions.isPrimal(14582734));
    }

    @Test
    void fibonacci() {
        assertEquals(2, MathFunctions.fibonacci(3));
        assertEquals(8, MathFunctions.fibonacci(6));
        assertEquals(12586269025L, MathFunctions.fibonacci(50));
    }

    @Test
    void getAllMultiples() {
        int[] arr = {2, 4};
        Integer[] expected = {4, 8, 12, 16};
        Integer[] actual = new Integer[4];
        MathFunctions.getAllMultiples(arr, 16).toArray(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void binaryInt() {
        assertEquals("1101", MathFunctions.binaryInt(13));
        assertEquals("11111", MathFunctions.binaryInt(31));
        assertEquals("1", MathFunctions.binaryInt(1));
    }

    @Test
    void minimum() {
        int[] arr = {4, 17, 7, 14, 18, 12, 3, 16, 10, 4, 4, 12};
        assertEquals(3, MathFunctions.minimum(arr));
        int[] arr1 = {4, 17, -7, 14, 18, -12, 3, 16, 10, -4, 4, 12};
        assertEquals(-12, MathFunctions.minimum(arr1));
    }
}