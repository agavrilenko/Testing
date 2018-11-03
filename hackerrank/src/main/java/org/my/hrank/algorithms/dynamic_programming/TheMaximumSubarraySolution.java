package org.my.hrank.algorithms.dynamic_programming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TheMaximumSubarraySolution {

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {
        int[] result = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

        //find max element
        int tmpSum = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (tmpSum < arr[i]) {
                tmpSum = arr[i];
                maxIdx = i;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == maxIdx) {
                continue;
            }
            tmpSum = tmpSum > tmpSum + arr[i] ? tmpSum : tmpSum + arr[i];
        }
        result[1] = tmpSum;
        int[] empty = new int[arr.length];
        int[][] possibleSum = new int[3][arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            possibleSum[0][i] = 0;
            possibleSum[1][i] = arr[i];
            possibleSum[2][i] = 0;
            max = max > arr[i] ? max : arr[i];
        }
        int counter = 2;
//        for (int i = 2; i < arr.length + 1; i++) {
        while (counter < arr.length + 1) {
            for (int j = 0; j < arr.length - counter + 1; j++) {
                possibleSum[2][j] = possibleSum[2 - 1][j] + possibleSum[2 - 1][j + 1] - possibleSum[2 - 2][j + 1];
                max = max > possibleSum[2][j] ? max : possibleSum[2][j];
            }
            possibleSum[0] = possibleSum[1];
            possibleSum[1] = possibleSum[2];
            possibleSum[2] = possibleSum[0];
            counter++;
        }
        result[0] = max;

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
