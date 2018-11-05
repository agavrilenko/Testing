package org.my.hrank.algorithms.dynamic_programming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
        /*int[][] possibleSum = new int[2][arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            possibleSum[0][i] = arr[i];
            possibleSum[1][i] = 0;
            max = max > arr[i] ? max : arr[i];
        }
        int counter = 1;
        long start = 0;
        long total = 0;
        while (counter < arr.length) {
            start = System.currentTimeMillis();
            for (int j = 0; j < arr.length - counter; j++) {
                possibleSum[1][j] = possibleSum[0][j] + arr[counter + j];
                max = max > possibleSum[1][j] ? max : possibleSum[1][j];
            }
            total += System.currentTimeMillis() - start;
            possibleSum[0] = possibleSum[1];
            counter++;
        }*/

//        https://en.wikipedia.org/wiki/Maximum_subarray_problem
        int max_ending_here = 0;
        int max_so_far = Integer.MIN_VALUE;
        /*OR int max_so_far = arr[0];*/

        for (int x : arr) {
            max_ending_here = Math.max(x, max_ending_here + x);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        result[0] = max_so_far;
//        System.out.println("Total time is " + total);
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
