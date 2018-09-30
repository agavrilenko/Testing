package org.my.hrank.data_structures.trees.swap_nodes_algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        idx = 0;
        Node root = buildTree(indexes);
        int[][] result = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            //swap
            int multple = 1;
            boolean swapped = true;
            while (swapped) {
                swapped = swapNodes(root, multple * queries[i]);
                multple++;
            }
            //print
            result[i] = printNodes(root);

        }

        return result;

    }

    private static int[] printNodes(Node root) {
        LinkedList<Integer> print = new LinkedList<>();
        printNodes(root.left, print);
        print.add(root.data);
        printNodes(root.right, print);
        return print.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void printNodes(Node root, LinkedList<Integer> print) {
        if (root == null || root.data == -1) {
            return;
        }
        if (root.left.data != -1) {
            printNodes(root.left, print);
        }
        print.add(root.data);
        if (root.right.data != -1) {
            printNodes(root.right, print);
        }
    }

    private static boolean swapNodes(Node root, int query) {
        boolean swapped = false;
        if (query <= 0 || root == null) {
            return false;
        }
        if (query == 1) {
            Node tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            return true;
        }
        if (root.left != null && root.left.data != -1) {
            swapped = swapNodes(root.left, query - 1);
        }
        if (root.right != null && root.right.data != -1) {
            swapped = swapNodes(root.right, query - 1) || swapped;
        }
        return swapped;
    }

    private static int idx = 0;

    private static Node buildTree(int[][] indexes) {
        Node root = new Node(1);
        root.left = new Node(indexes[idx][0]);
        root.right = new Node(indexes[idx++][1]);

        while (idx < indexes.length) {
            if (root.left.data != -1) {
                buildSubTree(indexes, root.left);
            }
            if (root.right.data != -1) {
                buildSubTree(indexes, root.right);
            }
        }
        return root;
    }

    private static void buildSubTree(int[][] indexes, Node root) {

        if (idx == indexes.length) {
            return;
        }
        if (root.left == null && root.right == null) {
            root.left = new Node(indexes[idx][0]);
            root.right = new Node(indexes[idx][1]);
            idx++;
            return;
        }
        if (root.left != null && root.left.data != -1) {
            buildSubTree(indexes, root.left);
        }
        if (root.right != null && root.right.data != -1) {
            buildSubTree(indexes, root.right);
        }
    }


    public static class Node {
        Node left;
        Node right;
        int data;

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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

