package org.aguinore.crackInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    private MyStack<Integer> myStack;
    @BeforeEach
    void setUp() {
        myStack = new MyStack<>();
    }

    @Test
    void put() {
        myStack.put(1);
        assertFalse(myStack.isEmpty());
    }

    @Test
    void pop() {
        assertNull(myStack.pop());
        myStack.put(1);
        assertEquals(Integer.valueOf(1), myStack.pop());
        assertTrue(myStack.isEmpty());
    }

    @Test
    void peek() {
        assertNull(myStack.peek());
        myStack.put(1);
        assertEquals(Integer.valueOf(1), myStack.peek());
        assertFalse(myStack.isEmpty());
    }

    @Test
    void isEmpty() {
        assertTrue(myStack.isEmpty());
        myStack.put(1);
        assertFalse(myStack.isEmpty());
    }

}