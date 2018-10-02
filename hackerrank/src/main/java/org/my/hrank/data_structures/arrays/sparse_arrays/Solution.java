package org.my.hrank.data_structures.arrays.sparse_arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] result = new int[queries.length];
        //build trie
        Node root = new Node('\u0000');
        for (String st : strings) {
            root.addNode(st.toCharArray());
        }
        //query trie
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            result[i] = root.match(query.toCharArray());
        }
        return result;
    }

    private static final int SIZE = (int) 'z' - (int) 'A' + 1;
    private static final int OFFSET = 'A';
    private static final char ZERO = '\u0000';

    private static class Node {
        char c;
        int cnt = 0;
        Node[] children = new Node[SIZE];

        public Node(char c) {
            this.c = c;
        }

        public void addNode(char[] chars) {
            char current = chars[0];
            int pos = current - OFFSET;
            Node firstNode;
            if (children[pos] == null) {
                children[pos] = new Node(current);
            }
            firstNode = children[pos];
            if (chars.length == 1) {
                firstNode.cnt++;
                return;
            }
            firstNode.addNode(1, chars);
        }

        public void addNode(int idx, char[] chars) {
            char current = chars[idx];
            int pos = current - OFFSET;
            Node nextNode;
            if (children[pos] == null) {
                children[pos] = new Node(current);
            }
            nextNode = children[pos];
            if (idx == chars.length - 1) {
                if (current == nextNode.c) {
                    nextNode.cnt++;
                }
                return;
            }
            nextNode.addNode(idx + 1, chars);
        }

        public int match(char[] chars) {
            return match(chars, 0);

        }

        private int match(char[] chars, int idx) {
            Node nextNode = children[chars[idx] - OFFSET];
            if (nextNode == null) {
                return 0;
            }
            if (idx + 1 == chars.length) {
                return nextNode.cnt;
            }
            return nextNode.match(chars, idx + 1);
        }

        @Override
        public String toString() {
            return "AbstractNode{" +
                    "c=" + c +
                    ", cnt=" + cnt +
                    ", children=" + Arrays.toString(children) +
                    '}';
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
