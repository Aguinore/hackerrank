package org.aguinore.crackInterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void add() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(7);
        tree.add(4);
        tree.add(5);
        tree.add(8);
        tree.add(2);
        tree.add(6);
        tree.add(5);

        assertTrue(tree.checkBST(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

}