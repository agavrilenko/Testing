package org.my.hrank.data_structures.trees.is_this_bst;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.my.hrank.data_structures.trees.is_this_bst.Solution.*;

public class IsThisBSTSolutionTest {
    @Test
    public void testBST_1(){

        Node root = new Node(3);
        Node left = new Node(5);
        root.left = left;
        Node right = new Node(2);
        root.right = right;
        left.left = new Node(1);
        left.right = new Node(4);
        right.left = new Node(6);


    }

}