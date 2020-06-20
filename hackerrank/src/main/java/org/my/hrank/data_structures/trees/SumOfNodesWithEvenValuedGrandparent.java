package org.my.hrank.data_structures.trees;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */
public class SumOfNodesWithEvenValuedGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        AtomicInteger sum = new AtomicInteger(0);
        traverseTree(sum, root, null, null);
        return sum.get();
    }

    private void traverseTree(AtomicInteger sum, TreeNode node, TreeNode parent, TreeNode grandParent) {
        if (node == null) {
            return;
        }
        if (grandParent != null && grandParent.val % 2 == 0) {
            sum.addAndGet(node.val);
        }
        traverseTree(sum, node.left, node, parent);
        traverseTree(sum, node.right, node, parent);
    }


    /*public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }*/
}
