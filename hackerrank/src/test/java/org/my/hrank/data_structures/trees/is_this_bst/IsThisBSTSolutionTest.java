package org.my.hrank.data_structures.trees.is_this_bst;

import org.junit.Assert;
import org.junit.Test;

import static org.my.hrank.data_structures.trees.is_this_bst.Solution.Node;

public class IsThisBSTSolutionTest {
    @Test
    public void testBST_False_1() {

        Node root = new Node(3);
        Node left = new Node(5);
        root.left = left;
        Node right = new Node(2);
        root.right = right;
        left.left = new Node(1);
        left.right = new Node(4);
        right.left = new Node(6);

        Assert.assertFalse(Solution.checkBST(root));
    }

    @Test
    public void testBST_False_2() {

        Node root = new Node(6);
        Node left = new Node(4);
        root.left = left;
        left.left = new Node(2);
        left.right = new Node(3);
        Node right = new Node(9);
        root.right = right;
        right.left = new Node(8);
        right.right = new Node(10);
        right.right.right = new Node(11);

        Assert.assertFalse(Solution.checkBST(root));
    }

    @Test
    public void testBST_False_3() {

        Node root = new Node(6);
        Node left = new Node(4);
        root.left = left;
        left.left = new Node(2);
        left.right = new Node(12);
        Node right = new Node(9);
        root.right = right;
        right.left = new Node(8);
        right.right = new Node(10);
        right.right.right = new Node(11);

        Assert.assertFalse(Solution.checkBST(root));
    }

    @Test
    public void testBST_False_4() {

        Node root = new Node(6);
        Node left = new Node(4);
        root.left = left;
        left.left = new Node(2);
        left.right = new Node(3);
        Node right = new Node(9);
        root.right = right;
        right.left = new Node(9);
        right.right = new Node(10);
        right.right.right = new Node(11);

        Assert.assertFalse(Solution.checkBST(root));
    }

    @Test
    public void testBST_False_5() {

        Node root = new Node(1);
        Node right = new Node(2);
        root.right = right;
        right.left = new Node(2);
        right.right = new Node(10);
        right.right.right = new Node(11);

        Assert.assertFalse(Solution.checkBST(root));
    }

    @Test
    public void testBST_False_6() {

        Node root = new Node(10);
        Node left = new Node(5);
        root.left = left;
        left.left = new Node(4);
        left.right = new Node(7);
        left.right.left = new Node(6);
        left.right.right = new Node(8);
        left.right.right.left = new Node(2);
        left.right.right.left.right = new Node(3);
        left.right.right.left.left = new Node(1);

        Assert.assertFalse(Solution.checkBST(root));
    }

    @Test
    public void testBST_True_2() {

        Node root = new Node(6);
        Node left = new Node(4);
        Node right = new Node(9);
        root.left = left;
        left.left = new Node(2);
        left.right = new Node(5);
        root.right = right;
        right.left = new Node(7);
        right.right = new Node(10);
        right.right.right = new Node(11);

        Assert.assertTrue(Solution.checkBST(root));
    }

    @Test
    public void testBST_True_4() {

        Node root = new Node(6);
        Node left = new Node(4);
        root.left = left;
        left.left = new Node(2);
        left.right = new Node(5);

        Assert.assertTrue(Solution.checkBST(root));
    }

    @Test
    public void testBST_True_3() {

        Node root = new Node(6);
        Node right = new Node(9);
        root.right = right;
        right.left = new Node(7);
        right.right = new Node(10);
        right.right.right = new Node(11);

        Assert.assertTrue(Solution.checkBST(root));
    }

    @Test
    public void testBST_True_1() {

        Node root = new Node(6);
        Node left = new Node(4);
        root.left = left;
        left.left = new Node(2);
        left.right = new Node(5);
        Node right = new Node(9);
        root.right = right;
        right.left = new Node(8);
        right.right = new Node(10);
        right.right.right = new Node(11);

        Assert.assertTrue(Solution.checkBST(root));
    }

}