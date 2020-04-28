package org.my.hrank.data_structures.trees.balanced_binary_tree;

import org.my.hrank.data_structures.trees.TreeNode;

public class IsBinaryTreeBalancedSolution {

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);

        return isBalanced;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftD = depth(node.left);
        int rightD = depth(node.right);

        if (Math.abs(leftD - rightD) > 1) {
            isBalanced = false;
        }

        return (rightD > leftD ? rightD : leftD) + 1;
    }
}
