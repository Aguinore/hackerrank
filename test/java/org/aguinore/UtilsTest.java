package org.aguinore;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void readArrayFromScanner() {
        createInputStreamWithArrayLength();
        int[] array = {1, 2, 3};
        assertArrayEquals(array, Utils.readArrayFromScanner());
    }

    @Test
    void readArrayFromScanner1() {
        createInputStreamWithArrayLength();
        Scanner scanner = new Scanner(System.in);
        int[] array = {1, 2, 3};
        assertArrayEquals(array, Utils.readArrayFromScanner(scanner));
    }

    @Test
    void readArrayFromScanner2() {
        createInputStreamWithArrayLength();
        Scanner scanner = new Scanner(System.in);
        int[] array = {3, 1, 2};
        assertArrayEquals(array, Utils.readArrayFromScanner(scanner, 3));
    }

    private void createInputStreamWithArrayLength() {
        String input = "3 1 2 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void sumArray() {
        int[] array = {1, 2, 3};
        assertEquals(6L, Utils.sumArray(array));
    }

    @Test
    void arrayToList() {
        int[] array = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> actual = Utils.arrayToList(array);
        assertIterableEquals(list, actual);
    }

    @Test
    void getArrayWithCounts() {
        int[] array = {1, 2, 3};
        int[] counts = {3, 2, 1};
        int[] expected = {1, 1, 1, 2, 2, 3};
        assertArrayEquals(expected, Utils.getArrayWithCounts(array, counts));
    }

    @Test
    void minKeyWithMaxCount() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        map.put(2, 2);
        map.put(3, 3);
        assertEquals(Integer.valueOf(1), Utils.minKeyWithMaxCount(map));
    }

    @Test
    void findCharInArray() {
        char[] array = {'a', 'b', '3'};
        assertEquals(1, Utils.findCharInArray(array, 'b'));
    }

    @Test
    void findCharInArray_notFound() {
        char[] array = {'1', '2', '3'};
        assertEquals(-1, Utils.findCharInArray(array, '4'));
    }

    @Test
    void bubbleSort() {
        int[] arr = {4, 17, 7, 14, 18, 12, 3, 16, 10, 4, 4, 12};
        int[] expected = {3, 4, 4, 4, 7, 10, 12, 12, 14, 16, 17, 18};
        assertArrayEquals(expected, Utils.bubbleSort(arr));
    }

    @Test
    void levenshteinDistance() {
        String str1 = "distance";
        String str2 = "editing";

        assertEquals(5, Utils.levenshteinDistance(str1, str2));
    }

    @Test
    void knapsackWithRepetitions() {
        int maxWeight = 10;
        int[] weights = {6, 3, 4, 2};
        int[] values = {30, 14, 16, 9};

        int[]  expected = {0, 0, 9, 14, 18, 23, 30, 32, 39, 44, 48};

        assertArrayEquals(expected, Utils.knapsackWithRepetitions(maxWeight, weights, values));
    }

    @Test
    void knapsackWithoutRepetitions() {
        int maxWeight = 10;
        int[] weights = {6, 3, 4, 2};
        int[] values = {30, 14, 16, 9};

        assertEquals(46, Utils.knapsackWithoutRepetitions(maxWeight, weights, values));
    }
}