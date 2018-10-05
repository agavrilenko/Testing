package org.my.hrank.data_structures.balanced_trees.self_balanced_tree;

import org.my.hrank.utils.AbstractNode;

public class Solution {

    public static Node insert(Node root, int val) {

        //calculate height
        calculateHeight(root);
        //insert value
        insertNode(root, val);
        //recalculate balance factor
        //check case when needToBalance is root itself
        Node needToBalance = recalculateBalance(root);
        //balance if needed
        if (needToBalance != null) {
            if (needToBalance == root) {
                balance(root);
            } else {
                balance(needToBalance);
            }
        }
        return root;
    }

    private static int calculateHeight(Node root) {
        if (root.left == null && root.right == null) {
            root.ht = 0;
            return 0;
        }
        int leftHt = 0;
        int rightHt = 0;
        if (root.left != null && root.left.val != -1) {
            leftHt = calculateHeight(root.left) + 1;
        }
        if (root.right != null && root.right.val != -1) {
            rightHt = calculateHeight(root.right) + 1;
        }
        root.ht = leftHt > rightHt ? leftHt : rightHt;
        return root.ht;
    }

    private static Node balance(Node needToBalance) {

        int balanceFactor = getBalanceFactor(needToBalance);
        //left tree heavier than right tree
        if (balanceFactor < -1) {
            int leftFactor = getBalanceFactor(needToBalance.left);
            Node left;
            Node leftRight;
            //left right case
            if (leftFactor > 0) {
                left = needToBalance.left;
                leftRight = needToBalance.left.right;
                needToBalance.left = leftRight;
                left.right = leftRight.left;
                leftRight.left = left; //need to add new Node(-1) when it is leaf
            }
            //left left case
            left = needToBalance.left;
            needToBalance.left = left.right;
            left.right = needToBalance;
            needToBalance = left;

        }
        //right tree heavier than left tree
        if (balanceFactor > 1) {
            int rightFactor = getBalanceFactor(needToBalance.right);
            //right left case
            Node right;
            Node rightLeft;
            if (rightFactor < 0) {
                right = needToBalance.right;
                rightLeft = right.left;
                needToBalance.right = rightLeft;
                right.left = rightLeft.right;
                rightLeft.right = right;
            }

            //right right case
            right = needToBalance.right;
            needToBalance.right = right.left;
            right.left = needToBalance;
            needToBalance = right;
        }

        return needToBalance;
    }

    /**
     * Return null if balance is not required otherwise returns node to be balanced
     *
     * @param root
     * @return
     */
    private static Node recalculateBalance(Node root) {

        int currentFactor = getBalanceFactor(root);
        if (currentFactor > 1) {
            int rightFactor = getBalanceFactor(root.right);
            if (rightFactor > 1) {
                return recalculateBalance(root.right);

            } else {
                return root;
            }
        }
        if (currentFactor < -1) {
            int leftFactor = getBalanceFactor(root.left);
            if (leftFactor < -1) {
                return recalculateBalance(root.left);
            } else {
                return root;
            }
        }

        return null;
    }

    private static int getBalanceFactor(Node root) {
        int leftHt = 0;
        int rightHt = 0;
        if (root.left != null && root.left.val != -1) {
            leftHt = root.left.ht + 1;
        }

        if (root.right != null && root.right.val != -1) {
            rightHt = root.right.ht + 1;
        }

        return rightHt - leftHt;
    }

    private static int insertNode(Node root, int val) {
        if (root == null) {
            root = newLeafNode(val);
            return root.ht;
        }
        int leftHt = 0;
        int rightHt = 0;
        if (root.val < val) {
            if (root.right != null && root.right.val != -1) {
                rightHt = insertNode(root.right, val) + 1;
            } else {
                root.right = newLeafNode(val);
                rightHt = 1;
            }
        }
        if (root.val > val) {
            if (root.left != null && root.left.val != -1) {
                leftHt = insertNode(root.left, val) + 1;
            } else {
                root.left = newLeafNode(val);
                leftHt = 1;
            }
        }
        root.ht = leftHt > rightHt ? leftHt : rightHt;
        return root.ht;
    }

    private static Node newNode(int val) {
        Node node = new Node();
        node.val = val;
        return node;
    }

    private static Node newLeafNode(int val) {
        Node node = new Node();
        node.val = val;
        node.ht = 0;
        node.left = newNode(-1);
        node.right = newNode(-1);
        return node;
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
