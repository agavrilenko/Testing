package org.my.hrank.algorithms.dynamic_programming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EqualSolution {
    //array of possible steps
    final static int[] steps = new int[]{1, 2, 5};

    static long equal(int[] arr) {

        Arrays.sort(arr);
        long finalSum = Long.MAX_VALUE;
        //check for all possible values added to initial array
        //if 0,4,4,9,9 then added 1 leads to 0,5,5,10,10 takes less operations.
        //the same for 0,3,3,8,8 adding 2 leads to 0,5,5,10,10
        //for general case wider range will be required.
        for (int j = 0; j < 3; j++) {
            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += findHops(arr[0], arr[i] + j);
            }
            finalSum = finalSum > sum ? sum : finalSum;
        }
        return finalSum;
    }


    private static long findHops(long start, long finish) {
        long diff = finish - start;
        return diff / 5 + diff % 5 / 2 + diff % 5 % 2;

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

            long result = equal(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
