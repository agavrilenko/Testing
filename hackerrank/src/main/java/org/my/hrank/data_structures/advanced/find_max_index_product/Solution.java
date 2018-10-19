package org.my.hrank.data_structures.advanced.find_max_index_product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the solve function below.
    static long solve(int[] arr) {

        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i], i);
        }

        //find max left
        Node root = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            findMaxLeft(root, nodes[i]);
            addNodeToTree(root, nodes[i], true);
        }
        for (Node node : nodes) {
            node.left = null;
            node.right = null;
            node.lastEqual = node.index;
        }
        root = nodes[nodes.length - 1];
        for (int i = nodes.length - 2; i >= 0; i--) {
            findMaxRight(root, nodes[i]);
            addNodeToTree(root, nodes[i], false);
        }

        long sum = 0;
        for (Node node : nodes) {
            int tmp = 0;
            int maxRight = node.maxRight;
            int maxLeft = node.maxLeft;
            if (maxRight != -1 && maxLeft != -1) {
                tmp = (maxLeft + 1) * (maxRight + 1);
            }
            sum = sum > tmp ? sum : tmp;
        }

        // if node.value > root - go right
        // if node.value <= root - go left

        //find max right


        return sum;
    }

    private static void addNodeToTree(Node root, Node node, boolean left) {
        if (root.value < node.value) {
            if (root.right != null) {
                addNodeToTree(root.right, node, left);
            } else {
                root.right = node;
            }
        } else if (root.value == node.value && root.lastEqual + 1 == node.index && left) {
            root.lastEqual++;
        } else if (root.value == node.value && root.lastEqual - 1 == node.index && !left) {
            root.lastEqual--;
        } else {
            if (root.left != null) {
                addNodeToTree(root.left, node, left);
            } else {
                root.left = node;
            }
        }
    }

    private static void findMaxLeft(Node root, Node node) {

        if (node.value > root.value && root.right != null) {
            //traverse right. Left doest have bigger value
            findMaxLeft(root.right, node);
        } else {
            if (root.value > node.value && root.index > node.maxLeft) {
                node.maxLeft = root.lastEqual;
            }
            if (root.left != null && root.left.value >= node.value) {
                findMaxLeft(root.left, node);
            }
            if (root.right != null) {
                findMaxLeft(root.right, node);
            }
        }

    }

    private static void findMaxRight(Node root, Node node) {

        if (node.value > root.value && root.right != null) {
            //traverse right. Left doest have bigger value
            findMaxRight(root.right, node);
        } else {
            if (root.value > node.value && root.index < node.maxRight) {
                node.maxRight = root.lastEqual;
            }
            if (root.left != null && root.left.value >= node.value) {
                findMaxRight(root.left, node);
            }
            if (root.right != null) {
                findMaxRight(root.right, node);
            }

        }

    }

    public static class Node {

        private int value;
        private Node left, right;
        private int index;
        private int lastEqual;
        private int maxLeft = -1;
        private int maxRight = Integer.MAX_VALUE;


        public Node(int value, int index) {
            this.value = value;
            this.index = index;
            this.lastEqual = index;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", index=" + index +
                    ", maxLeft=" + maxLeft +
                    ", maxRight=" + maxRight +
                    '}';
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        long result = solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
