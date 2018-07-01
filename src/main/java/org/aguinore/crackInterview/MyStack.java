package org.aguinore.crackInterview;

import java.util.LinkedList;
import java.util.List;

/**
 * for the "Balanced Brackets" and "A Tale of Two Stacks" problems
 */
public class MyStack<E> {
    private List<E> stack = new LinkedList<>();

    public void put(E element) {
        stack.add(element);
    }

    public E pop() {
        if (!stack.isEmpty()) {
            return stack.remove(stack.size() - 1);
        }
        return null;
    }

    public E peek() {
        if (!stack.isEmpty()) {
            return stack.get(stack.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
