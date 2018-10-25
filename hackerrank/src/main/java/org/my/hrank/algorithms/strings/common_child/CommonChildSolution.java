package org.my.hrank.algorithms.strings.common_child;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommonChildSolution {
    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
//https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
        char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();
        int[][] matrix = new int[first.length + 1][second.length + 1];

        //first column and row are 0. chars will be at i-1, j-1
        for (int i = 1; i < first.length + 1; i++) {
            for (int j = 1; j < second.length + 1; j++) {
                if (first[i - 1] == second[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = getMax(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        Set<String> strings = backtrackAll(matrix, first, second, first.length, second.length);
        return matrix[first.length][second.length];

    }

    private static Set<String> backtrackAll(int[][] matrix, char[] first, char[] second, int i, int j) {

        if (i == 0 || j == 0) {
            HashSet<String> strings = new HashSet<>();
            return strings;
        }
        if (first[i - 1] == second[j - 1]) {
            Set<String> strings = backtrackAll(matrix, first, second, i - 1, j - 1);
            if (strings.size() == 0) {
                strings.add(String.valueOf(first[i - 1]));
                return strings;
            } else {
                HashSet<String> newStrings = new HashSet<>();
                for (String string : strings) {
                    newStrings.add(string + String.valueOf(first[i - 1]));

                }
                return newStrings;
            }
        }
        HashSet<String> strings = new HashSet<>();
        if (matrix[i][j - 1] >= matrix[i - 1][j]) {
            strings.addAll(backtrackAll(matrix, first, second, i, j - 1));
        }
        if (matrix[i - 1][j] >= matrix[i - 1][j]) {
            strings.addAll(backtrackAll(matrix, first, second, i - 1, j));
        }
        return strings;

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
