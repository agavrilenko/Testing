package org.my.hrank.data_structures.trees.bst_least_common_ancestor;

import org.my.hrank.data_structures.trees.TreeNode;

/**
 * Lowest Common Ancestor of a Binary Tree. https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode next = root;

        while (next != null) {

            if (belongToTree(next.left, q) && belongToTree(next.left, p)) {
                next = next.left;
            } else if (belongToTree(next.right, q) && belongToTree(next.right, p)) {
                next = next.right;
            } else {
                break;
            }
        }
        return next;
    }

    private boolean belongToTree(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        }
        return belongToTree(root.left, p) || belongToTree(root.right, p);
    }
}
