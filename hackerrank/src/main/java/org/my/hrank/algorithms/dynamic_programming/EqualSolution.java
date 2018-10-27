package org.my.hrank.algorithms.dynamic_programming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EqualSolution {
    // Complete the equal function below.
    final static int[] steps = new int[]{1, 2, 5};

    static long equal(int[] arr) {

        //1. sort array array
        //1.0. could be sorted in linear time as it is int[]
        Arrays.sort(arr);

        //2. increase all except penultimate to make same values to
        //smallest and penultimate
        ArrayList<Integer> additions = new ArrayList<>();
        long sum = 0;
        int cur = arr[0];
        long added = 0;
        int i = 1;
        while (i < arr.length) {
            if (cur == arr[i]) {
                i++;
                continue;
            }
            if ( arr[i] - cur == 4) {
                //add 1 to jump for 5
            }

            int hops = findHops(cur, arr[i], additions);
            sum += hops;
            added += arr[i] - cur;
            cur = arr[i];
            if (i != arr.length - 1) {
                arr[i + 1] += added;
            }
            i++;
        }
        return sum;
    }

    private static int findHops(int start, int finish, ArrayList<Integer> additions) {
        Hop[] road = new Hop[finish - start + 1];
        //final value should be finish, but we have offset of start value
        //to decrease number of computations
        road[0] = new Hop(0, 0);
        for (int i = 0; i < road.length; i++) {
            if (road[road.length - 1] != null) {
                break;
            }
            for (int j = 0; j < steps.length; j++) {
                //compare Hop on next index. if that index bigger than possibleHop.index replace with possibleHop
                Hop possibleHop = new Hop(road[i].index + 1, road[i].value + steps[j]);
                if (possibleHop.value >= road.length) {
                    continue;
                }
                Hop next = road[possibleHop.value];
                if (next == null || next.index > possibleHop.index) {
                    road[possibleHop.value] = possibleHop;
                }
            }
        }
        int idx = road.length - 1;
        Hop prev = road[idx];
//        while (prev.index != 0) {
//            additions.add(prev.value);
//            idx = idx - prev.value;
//            prev = road[idx];
//        }
        return road[road.length - 1].index;
    }

    public static class Hop {
        int index;
        int value;

        public Hop(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Hop{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
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
