package org.my.hrank.data_structures.trees.validate_bst;

import org.my.hrank.data_structures.trees.TreeNode;

public class ValidateBSTSolution {

    public boolean isValidBST(TreeNode root) {

        boolean isValid = validate(root);
        return isValid;
    }

    private boolean validate(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode max = getMax(root.left);
        TreeNode min = getMin(root.right);

        boolean isValid = true;
        if (max != null && max.val >= root.val) {
            isValid = false;
        }
        if (min != null && min.val <= root.val) {
            isValid = false;
        }
        return isValid && validate(root.left) && validate(root.right);
    }

    private TreeNode getMin(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode n;
        if (node.left == null && node.right != null) {
            n = getMin(node.right);
            if (n.val < node.val) {
                return n;
            }
            return node;
        }

        if (node.left != null && node.right == null) {
            n = getMin(node.left);
            if (n.val < node.val) {
                return n;
            }
            return node;
        }
        TreeNode l = getMin(node.left);
        TreeNode r = getMin(node.right);
        TreeNode min = node;
        if (min.val > l.val) {
            min = l;
        }
        if (min.val > r.val) {
            min = r;
        }
        return min;

    }

    private TreeNode getMax(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode n;
        if (node.left == null && node.right != null) {
            n = getMax(node.right);
            if (n.val > node.val) {
                return n;
            }
            return node;
        }

        if (node.left != null && node.right == null) {
            n = getMax(node.left);
            if (n.val > node.val) {
                return n;
            }
            return node;
        }
        TreeNode l = getMax(node.left);
        TreeNode r = getMax(node.right);
        TreeNode max = node;
        if (max.val < l.val) {
            max = l;
        }
        if (max.val < r.val) {
            max = r;
        }
        return max;
    }
}
