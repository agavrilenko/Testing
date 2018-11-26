package org.my.hrank.algorithms.dynamic_programming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class CandiesSolution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        long[] cand = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            cand[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                cand[i] = Math.max(cand[i - 1] + 1, cand[i]);
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                cand[i] = Math.max(cand[i + 1] + 1, cand[i]);
            }

        }

        return stream(cand).reduce((x, y) -> x + y).orElse(0);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
