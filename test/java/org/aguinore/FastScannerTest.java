package org.aguinore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FastScannerTest {

    private FastScanner fastScanner;
    @BeforeEach
    void setUp() {
    }

    @Test
    void nextLine() {
        fastScanner = new FastScanner(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("fastScanner/linetest"));
        String line = fastScanner.nextLine();
        String expected = "Hello, world!";
        assertEquals(expected, line);
    }

    @Test
    void nextInt() {
        fastScanner = new FastScanner(Thread.currentThread().getContextClassLoader()
            .getResourceAsStream("fastScanner/nextIntTest"));
        int i1 = fastScanner.nextInt();
        assertEquals(12, i1);
        int i2 = fastScanner.nextInt();
        assertEquals(10, i2);
        int i3 = fastScanner.nextInt();
        assertEquals(3, i3);
        int i4 = fastScanner.nextInt();
        assertEquals(1, i4);
        assertThrows(IllegalStateException.class, () -> fastScanner.nextInt());

    }

    @Test
    void nextLong() {
        fastScanner = new FastScanner(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("fastScanner/nextIntTest"));
        long i1 = fastScanner.nextLong();
        assertEquals(12, i1);
        long i2 = fastScanner.nextLong();
        assertEquals(10, i2);
        long i3 = fastScanner.nextLong();
        assertEquals(3, i3);
        long i4 = fastScanner.nextLong();
        assertEquals(1, i4);
        assertThrows(IllegalStateException.class, () -> fastScanner.nextLong());
    }

    @Test
    void nextDouble() {
        fastScanner = new FastScanner(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("fastScanner/nextDoubleTest"));
        double i1 = fastScanner.nextDouble();
        assertEquals(12.0, i1);
        double i2 = fastScanner.nextDouble();
        assertEquals(10.0, i2);
        double i3 = fastScanner.nextDouble();
        assertEquals(3.0, i3);
        double i4 = fastScanner.nextDouble();
        assertEquals(1.0, i4);
        assertThrows(IllegalStateException.class, () -> fastScanner.nextDouble());
    }
}