package org.my.hrank.data_structures.trees.is_this_bst;

public class Solution {
    public static boolean checkBST(Node root) {

        if (root == null) {
            return true;
        }

        boolean isBst = true;
        if (root.left != null) {
            int maxLeft = max(root.left);
            if (maxLeft == -1) {
                return false;
            }
            isBst = maxLeft < root.data;
        }
        if (root.right != null) {
            int minRight = min(root.right);
            if (minRight == -1) {
                return false;
            }
            isBst = isBst && minRight > root.data;
        }
        return isBst;
    }

    private static int max(Node root) {

        int max = root.data;
        if (root.left != null) {
            int maxLeft = max(root.left);
            if (maxLeft == -1 || root.data <= maxLeft) {
                return -1;
            }
            max = max > maxLeft ? max : maxLeft;
        }
        if (root.right != null) {
            int maxRight = max(root.right);
            if (maxRight == -1) {
                return -1;
            }
            max = max > maxRight ? max : maxRight;
            int minRight = min(root.right);
            if (minRight == -1 || minRight <= root.data) {
                return -1;
            }
        }

        return max;
    }

    static int min(Node root) {
        int min = root.data;
        if (root.left != null) {
            int minLeft = min(root.left);
            if (minLeft == -1) {
                return -1;
            }
            min = min < minLeft ? min : minLeft;
            int maxLeft = max(root.left);
            if (maxLeft == -1 || maxLeft >= root.data) {
                return -1;
            }
        }
        if (root.right != null) {
            int minRight = min(root.right);
            if (minRight == -1 || root.data >= minRight) {
                return -1;
            }
            min = min < minRight ? min : minRight;
        }
        return min;

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
