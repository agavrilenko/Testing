package org.my.hrank.algorithms.dynamic_programming;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SubstringDiffSolution {

    // Complete the substringDiff function below.
    private static int smaller(int a, int b) {
        return a < b ? a : b;
    }

    private static int larger(int a, int b) {
        return a > b ? a : b;
    }

    private static int solve(int k, String sa, String sb) {
        int best = 0, n = sb.length();
        Queue<Integer> q = new ArrayDeque<>();
        for (int off = 0; off < n; ++off) {
            for (int i = 0; i + off < n; ++i) {
                if (sa.charAt(i) == sb.charAt(off + i)) {
                    q.add(i);
                    while (i - q.peek() + 1 - q.size() > k) {
                        q.remove();
                    }
                    int score = q.size() + smaller(k, n - off - q.size());
                    if (score > best) {
                        best = score;
                    }
                }
            }
            q.clear();
        }
        return best;
    }

    static int substringDiff(int k, String s1, String s2) {
        return larger(solve(k, s1, s2), solve(k, s2, s1));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] kS1S2 = scanner.nextLine().split(" ");

            int k = Integer.parseInt(kS1S2[0]);

            String s1 = kS1S2[1];

            String s2 = kS1S2[2];

            int result = substringDiff(k, s1, s2);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
