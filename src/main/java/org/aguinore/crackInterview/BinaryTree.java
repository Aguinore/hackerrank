package org.aguinore.crackInterview;

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    public void add(E element) {
        if (root == null) {
            root = new Node<>(element);
            return;
        }
        Node<E> prev = null;
        Node<E> current = root;
        while (current != null) {
            prev = current;
            if (element.compareTo(current.data) < 0) {
                current = current.left;
            } else if (element.compareTo(current.data) > 0) {
                current = current.right;
            }
        }

        if (element.compareTo(prev.data) < 0) {
            prev.left = new Node<>(element);
        } else {
            prev.right = new Node<>(element);
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root.data +
                '}';
    }

    private static class Node<E> {
        private Node<E> left;
        private Node<E> right;
        private E data;

        public Node(E data) {
            this.data = data;
        }
    }
}

