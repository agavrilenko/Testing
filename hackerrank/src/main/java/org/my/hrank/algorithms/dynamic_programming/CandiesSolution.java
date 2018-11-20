package org.my.hrank.algorithms.dynamic_programming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CandiesSolution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        long toAdd = 1;
        long sum = 0;
        long dec = 0;
        long chg = 0;
        int up = 0;
        long localMax = 0;
        int[] tmp = new int[arr.length + 1];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        arr = tmp;
        arr[arr.length - 1] = arr[arr.length - 2];
        if (arr[0] > arr[1]) {
            up = -1;
        } else if (arr[0] < arr[1]) {
            up = 1;
        } else {
            up = 0;
        }
        //need to know length of raise and length of fall. Take max of peak.
        //check when starting from decreasing
        for (int i = 0; i < arr.length - 1; i++) {

            if (up == 1) {
                if (arr[i] < arr[i + 1]) {
                    chg++;
                }
                if (arr[i] > arr[i + 1]) {
                    sum += chg * (chg + 1) / 2;
                    localMax = chg + 1;
                    up = -1;
                    chg = 1;
                }
                if (arr[i] == arr[i + 1]) {
                    sum += chg * (chg + 1) / 2;
                    localMax = 0;
                    up = 0;
                }
                continue;
            }
            if (up == -1) {
                if (arr[i] > arr[i + 1]) {
                    chg++;
                }
                if (arr[i] < arr[i + 1]) {
                    sum += chg * (chg + 1) / 2;
                    chg++;
                    sum += Math.max(localMax, chg);
                    chg = 1;

                    up = 1;
                }
                if (arr[i] == arr[i + 1]) {
                    up = 0;
                    sum += chg * (chg + 1) / 2;
                    chg++;
                    sum += Math.max(localMax, chg);
                    chg = 1;
                }
                continue;
            }
            if (up == 0) {
                if (arr[i] > arr[i + 1]) {
                    chg++;
                    up = -1;
                }
                if (arr[i] < arr[i + 1]) {
                    chg++;
                    up = 1;
                }
                if (arr[i] == arr[i + 1]) {
                    up = 0;
                    sum += 1;
                }
            }


            /*sum += toAdd;
            if (arr[i] < arr[i + 1] && dec == 0) {
                toAdd++;
                continue;
            }
            if (arr[i] == arr[i + 1] && dec == 0) {
                toAdd = 1;
                continue;
            }
            if (arr[i] > arr[i + 1]) {
                toAdd--;
                dec++;
                continue;
            }
            if (arr[i] <= arr[i + 1] && dec != 0) {
                sum -= dec * (toAdd - 1);
                if (arr[i] < arr[i + 1]) {
                    toAdd = 2;
                }
                if (arr[i] == arr[i + 1]) {
                    toAdd = 1;
                }
                dec = 0;
            }*/
        }
        return sum;
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
