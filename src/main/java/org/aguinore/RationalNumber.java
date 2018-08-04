package org.aguinore;

import java.util.Objects;

public class RationalNumber {
    private final long numerator;
    private final long denominator;

    //TODO what to do with 0 in denominator?
    public RationalNumber(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public RationalNumber add(RationalNumber number) {
        long newNumerator = this.numerator * number.denominator + this.denominator * number.numerator;
        long newDenominator = this.denominator * number.denominator;
        return new RationalNumber(newNumerator, newDenominator).simplify();
    }

    public RationalNumber subtract(RationalNumber number) {
        return add(number.multiply(-1));
    }

    public RationalNumber multiply(RationalNumber number) {
        return new RationalNumber(numerator * number.numerator, denominator * number.denominator)
                .simplify();
    }

    public RationalNumber multiply(Integer number) {
        return new RationalNumber(numerator * number, denominator)
                .simplify();
    }

    public RationalNumber simplify() {
        if (numerator == 0) {
            return new RationalNumber(0, 0);
        }
        long newNumerator = numerator;
        long newDenominator = denominator;
        while (newNumerator % 2 == 0 && newDenominator % 2 == 0) {
            newNumerator /= 2;
            newDenominator /= 2;
        }

        double upperBound = newNumerator;
        for (int i = 3; i <= upperBound; i++) {
            if (newNumerator % i == 0 && newDenominator % i == 0) {
                newNumerator /= i;
                newDenominator /= i;
                upperBound = newNumerator;
            }
        }
        return new RationalNumber(newNumerator, newDenominator);
    }

    public static RationalNumber of(double number) {
        long denominator = 10;
        number  = number * denominator;
        while (number - Math.round(number) > 0.000000000001) {
            denominator *= 10;
            number *= 10;
        }
        return new RationalNumber(Math.round(number), denominator).simplify();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RationalNumber that = (RationalNumber) o;
        return numerator == that.numerator &&
                denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return "RationalNumber{" +
                numerator +
                "/" + denominator +
                '}';
    }
}
