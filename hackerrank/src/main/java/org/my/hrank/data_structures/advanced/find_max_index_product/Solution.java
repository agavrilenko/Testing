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
        for (int i = 1; i < nodes.length - 1; i++) {
            if (nodes[i].value < nodes[i - 1].value) {
                nodes[i].maxLeft = nodes[i - 1].index;
            } else if (nodes[i].value == nodes[i - 1].value) {
                nodes[i].maxLeft = nodes[i - 1].maxLeft;
            } else {
                getMaxLeft(nodes, nodes[i - 1], nodes[i]);
            }

        }

        for (int i = nodes.length - 2; i > 0; i--) {
            if (nodes[i].value < nodes[i + 1].value) {
                nodes[i].maxRight = nodes[i + 1].index;
            } else if (nodes[i].value == nodes[i + 1].value) {
                nodes[i].maxRight = nodes[i + 1].maxRight;
            } else {
                getMaxRight(nodes, nodes[i + 1], nodes[i]);
            }

        }

        long sum = 0;
        for (Node node : nodes) {
            long tmp = 0;
            long maxRight = node.maxRight;
            long maxLeft = node.maxLeft;
            if (maxRight != -1 && maxLeft != -1 && maxRight != Integer.MAX_VALUE && maxLeft != Integer.MAX_VALUE) {
                tmp = (maxLeft + 1) * (maxRight + 1);
            }
            sum = sum > tmp ? sum : tmp;
        }

        return sum;
    }

    private static void getMaxLeft(Node[] nodes, Node left, Node node) {

        int maxLeft = left.maxLeft;
        if (maxLeft == -1) {
            return;
        }
        if (nodes[maxLeft].value > node.value) {
            node.maxLeft = nodes[maxLeft].index;
        } else {
            getMaxLeft(nodes, nodes[maxLeft], node);
        }
    }

    private static void getMaxRight(Node[] nodes, Node right, Node node) {

        int maxRight = right.maxRight;
        if (maxRight == Integer.MAX_VALUE) {
            return;
        }
        if (nodes[maxRight].value > node.value) {
            node.maxRight = nodes[maxRight].index;
        } else {
            getMaxRight(nodes, nodes[maxRight], node);
        }
    }


    public static class Node {

        private int value;
        private int index;
        private int maxLeft = -1;
        private int maxRight = Integer.MAX_VALUE;


        public Node(int value, int index) {
            this.value = value;
            this.index = index;
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
