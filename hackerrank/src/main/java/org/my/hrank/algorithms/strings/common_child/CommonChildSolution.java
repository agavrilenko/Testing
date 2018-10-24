package org.my.hrank.algorithms.strings.common_child;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class CommonChildSolution {
    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        int[][] matrix = new int[s1Chars.length + 1][s2Chars.length + 1];

        //first column and row are 0. chars will be at i-1, j-1
        for (int i = 1; i < s1Chars.length + 1; i++) {
            for (int j = 1; j < s2Chars.length + 1; j++) {
                if (s1Chars[i - 1] == s2Chars[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = getMax(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }


        return matrix[s1Chars.length][s2Chars.length];

    }

    private static void backtrackAll(int[][] matrix, char[] first, char[] second, int i, int j, LinkedList<String> result) {
        if (i == 0 || j == 0) {
            return;
        }
        if (first[i] == second[j]) {
            backtrackAll(matrix, first, second, i - 1, j - 1, result);
            result.forEach(st -> st = st.concat(String.valueOf(first[i])));
            return;
        }
        if (matrix[i][j - 1] >= matrix[i - 1][j]) {
        }

    }

    private static int getMax(int max, int current) {
        return max > current ? max : current;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
