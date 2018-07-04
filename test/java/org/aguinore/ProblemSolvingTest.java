package org.aguinore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProblemSolvingTest {

    @Test
    void appendAndDelete() {
        String s = "hackerhappy";
        String t = "hackerrank";
        assertEquals("Yes", ProblemSolving.appendAndDelete(s, t, 9));
    }
    @Test
    void appendAndDelete1() {
        String s = "abcd";
        String t = "abcdert";
        assertEquals("No", ProblemSolving.appendAndDelete(s, t, 10));
    }
    @Test
    void appendAndDelete2() {
        String s = "aaa";
        String t = "a";
        assertEquals("Yes", ProblemSolving.appendAndDelete(s, t, 5));
    }
    @Test
    void appendAndDelete3() {
        String s = "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv";
        String t = "bsdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv";
        assertEquals("Yes", ProblemSolving.appendAndDelete(s, t, 100));
    }
}