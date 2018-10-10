package org.my.hrank.data_structures.disjoint_set.components_in_graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the componentsInGraph function below.
     */
    static int[] componentsInGraph(int[][] gb) {

        //build graph
        Node[] graph = new Node[2 * gb.length];
        for (int i = 0; i < gb.length; i++) {
            int leftValue = gb[i][0];
            int rightValue = gb[i][1];
            Node leftNode = graph[leftValue - 1];
            Node rightNode = graph[rightValue - 1];
            if (leftNode == null) {
                leftNode = new Node(leftValue);
                graph[leftValue - 1] = leftNode;
            }
            if (rightNode == null) {
                rightNode = new Node(rightValue);
                graph[rightValue - 1] = rightNode;
            }
            leftNode.addNode(rightNode);
            rightNode.addNode(leftNode);
        }
        //traverse graph
        int graphId = 0;
        LinkedList<Integer> counts = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == null || graph[i].treeId != -1) {
                continue;
            }
            counts.add(traverseGraph(graph[i], graphId++));

        }
        //get result


        int[] result = new int[]{Integer.MAX_VALUE, 0};
        while (counts.size() > 0) {
            int cnt = counts.removeFirst();
            if (cnt < result[0]) {
                result[0] = cnt;
            }
            if (cnt > result[1]) {
                result[1] = cnt;
            }
        }
        return result;
    }

    private static int traverseGraph(Node node, int graphId) {
        LinkedList<Node> friends = new LinkedList<>();
        int count = 0;
        node.treeId = graphId;
        count++;
        friends.addAll(node.friends);
        while (friends.size() > 0) {
            Node friend = friends.removeFirst();
            if (friend.treeId == -1) {
                friend.treeId = graphId;
                count++;
                friends.addAll(friend.friends);
            }
        }
        return count;
    }

    public static class Node {
        int value;
        int treeId = -1;
        ArrayList<Node> friends = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }

        public void addNode(Node another) {
            friends.add(another);
        }

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] result = componentsInGraph(gb);

        for (int SPACEItr = 0; SPACEItr < result.length; SPACEItr++) {
            bufferedWriter.write(String.valueOf(result[SPACEItr]));

            if (SPACEItr != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

