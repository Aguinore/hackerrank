package org.aguinore.crackInterview;

/**
 * for the "A Tale of Two Stacks" problem
 * The queue is implemented with two stacks.
 */
public class MyQueue<E> {
    private MyStack<E> head = new MyStack<>();
    private MyStack<E> tail = new MyStack<>();

    public void enqueue(E element) {
        head.put(element);
    }

    public E dequeue() {
        moveIfNecessary();
        return tail.pop();
    }

    public E peek() {
        moveIfNecessary();
        return tail.peek();
    }

    public boolean isEmpty() {
        return head.isEmpty() && tail.isEmpty();
    }

    /**
     * if tail is empty we should move all from head to tail.
     * head = (3, 2, 1) => tail = (1, 2, 3) so 1 was first enqueued and will be last dequeued
     */
    private void moveIfNecessary() {
        if (tail.isEmpty()) {
            while (!head.isEmpty()) {
                tail.put(head.pop());
            }
        }
    }
}
