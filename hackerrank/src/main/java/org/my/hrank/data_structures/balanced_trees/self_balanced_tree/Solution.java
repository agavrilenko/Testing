package org.my.hrank.data_structures.balanced_trees.self_balanced_tree;

import org.my.hrank.utils.AbstractNode;

public class Solution {

    static Node insert(Node root, int val) {

        //insert value
        //check is balanced
        //balance
        return null;
    }

    public static class Node implements AbstractNode {
        int val;    //Value
        int ht;        //Height
        Node left;    //Left child
        Node right;    //Right child

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", ht=" + ht +
                    '}';
        }

        public Node() {
        }

        ;

        public int getData() {
            return val;
        }

        public void setData(int val) {
            this.val = val;
        }

        @Override
        public Node getLeft() {
            return left;
        }


        @Override
        public Node getRight() {
            return right;
        }

        @Override
        public <T extends AbstractNode> void setLeft(T left) {
            this.left = (Node) left;

        }

        @Override
        public <T extends AbstractNode> void setRight(T right) {
            this.right = (Node) right;

        }

    }
}
