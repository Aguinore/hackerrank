package org.aguinore.crackInterview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void add() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        assertTrue(tree.checkBST(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

}