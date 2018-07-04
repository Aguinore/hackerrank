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
        String input = "1 2 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        int[] array = {1, 2, 3};
        assertArrayEquals(array, Utils.readArrayFromScanner(scanner, 3));
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

    private void createInputStreamWithArrayLength() {
        String input = "3 1 2 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
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
    void primality() {
        for (int i = 1; i <= 29; i++) {
            assertFalse(Utils.isPrimal(i * i));
        }
        assertTrue(Utils.isPrimal(907));
        assertFalse(Utils.isPrimal(14582734));
    }

    @Test
    void fibonacci() {
        assertEquals(2, Utils.fibonacci(3));
        assertEquals(8, Utils.fibonacci(6));
    }

    @Test
    void getAllMultiples() {
        int[] arr = {2, 4};
        Integer[] expected = {4, 8, 12, 16};
        Integer[] actual = new Integer[4];
        Utils.getAllMultiples(arr, 16).toArray(actual);
        assertArrayEquals(expected, actual);
    }
}