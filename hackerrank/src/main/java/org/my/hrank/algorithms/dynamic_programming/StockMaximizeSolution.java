package org.my.hrank.algorithms.dynamic_programming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StockMaximizeSolution {

    // Complete the stockmax function below.
    static long stockmax(int[] prices) {

        int localMax = 0;
        int sum = 0;
        long lSum = 0;
        int[] extPr = new int[prices.length + 1];
        extPr[0] = Integer.MAX_VALUE;
        System.arraycopy(prices, 0, extPr, 1, prices.length);
        for (int i = extPr.length - 1; i > 0; i--) {
            if (extPr[i] <= extPr[i - 1] && localMax == 0) {
                continue;
            }
            if (extPr[i] > localMax && localMax != 0) {
                localMax = 0;
            }
            if (extPr[i] > extPr[i - 1] && localMax == 0) {
                localMax = extPr[i];
                continue;
            }
            if (localMax > 0) {
                lSum += localMax - extPr[i];
            }

        }
        return lSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] prices = new int[n];

            String[] pricesItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int pricesItem = Integer.parseInt(pricesItems[i]);
                prices[i] = pricesItem;
            }

            long result = stockmax(prices);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
