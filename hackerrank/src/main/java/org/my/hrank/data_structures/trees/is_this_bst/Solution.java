package org.my.hrank.data_structures.trees.is_this_bst;

public class Solution {
    public static boolean checkBST(Node root) {
        return false;
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
