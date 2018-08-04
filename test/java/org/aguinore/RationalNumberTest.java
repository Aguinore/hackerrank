package org.aguinore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalNumberTest {

    @Test
    void add() {
        RationalNumber n = new RationalNumber(1, 3);
        RationalNumber m = new RationalNumber(2, 5);

        RationalNumber res = new RationalNumber(11, 15);
        assertEquals(res, n.add(m));
    }

    @Test
    void multiplyTest() {
        RationalNumber n = new RationalNumber(1, 3);
        RationalNumber m = new RationalNumber(3, 5);

        RationalNumber res = new RationalNumber(1, 5);
        assertEquals(res, n.multiply(m));
    }

    @Test
    void simplifySimpleTest() {
        RationalNumber n = new RationalNumber(1, 12);
        assertEquals(n, n.simplify());
    }

    @Test
    void simplifyPowerOfTwoTest() {
        RationalNumber n = new RationalNumber(8, 16);
        RationalNumber res = new RationalNumber(1, 2);
        assertEquals(res, n.simplify());
    }

    @Test
    void simplifyTest() {
        RationalNumber n = new RationalNumber(6, 15);
        RationalNumber res = new RationalNumber(2, 5);
        assertEquals(res, n.simplify());
    }

    @Test
    void simplifyOneTest() {
        RationalNumber n = new RationalNumber(7, 7);
        RationalNumber res = new RationalNumber(1, 1);
        assertEquals(res, n.simplify());
    }

    @Test
    void ofAppropriate() {
        assertEquals(new RationalNumber(1, 2), RationalNumber.of(0.5));
        assertEquals(new RationalNumber(1, 5), RationalNumber.of(0.2));
        assertEquals(new RationalNumber(1, 3), RationalNumber.of(0.333));
    }

    @Test
    void ofInappropriate() {
        assertThrows(IllegalArgumentException.class, () -> RationalNumber.of(0.14));
    }
}