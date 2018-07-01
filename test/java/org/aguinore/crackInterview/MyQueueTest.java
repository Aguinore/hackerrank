package org.aguinore.crackInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    private MyQueue<Integer> myQueue;
    @BeforeEach
    void setUp() {
        myQueue = new MyQueue<>();
    }

    @Test
    void enqueue() {
        assertTrue(myQueue.isEmpty());
        myQueue.enqueue(1);
        assertFalse(myQueue.isEmpty());
    }

    @Test
    void dequeue() {
        assertNull(myQueue.dequeue());
        myQueue.enqueue(1);
        assertEquals(Integer.valueOf(1), myQueue.dequeue());
    }

    @Test
    void peek() {
        assertNull(myQueue.peek());
        myQueue.enqueue(1);
        assertEquals(Integer.valueOf(1), myQueue.peek());
    }

    @Test
    void isEmpty() {
        assertTrue(myQueue.isEmpty());
        myQueue.enqueue(1);
        assertFalse(myQueue.isEmpty());
    }

}