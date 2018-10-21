package org.my.hrank.data_structures.advanced.jim_and_skyscrapers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    // Complete the solve function below.
    static long solve(int[] arr) {

        long sum = 0;
        long count;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addFirst(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.peekFirst() >= arr[i]) {
                stack.addFirst(arr[i]);
            }
            if (stack.peekFirst() < arr[i]) {
                while (stack.size() > 0 && arr[i] > stack.peekFirst()) {
                    int penultimate = stack.removeFirst();
                    count = 1;
                    while (stack.size() > 0 && penultimate == stack.peekFirst()) {
                        count++;
                        penultimate = stack.removeFirst();
                    }
                    sum += count * (count - 1);
                }
                stack.addFirst(arr[i]);
            }
        }

        while (stack.size() > 0) {
            int last = stack.removeFirst();
            if (stack.size() > 0 && last == stack.peekFirst()) {
                count = 1;
                while (stack.size() > 0 && last == stack.peekFirst()) {
                    last = stack.removeFirst();
                    count++;
                }
                sum += count * (count - 1);
            }
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        long result = solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

