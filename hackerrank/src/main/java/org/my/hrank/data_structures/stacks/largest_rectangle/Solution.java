package org.my.hrank.data_structures.stacks.largest_rectangle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        LinkedList<House> stack = new LinkedList<>();



        return 0;
    }

    public static class House {
        int height;
        int position;

        public House(int height, int position) {
            this.height = height;
            this.position = position;
        }

        @Override
        public String toString() {
            return "House{" +
                    "height=" + height +
                    ", position=" + position +
                    '}';
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
