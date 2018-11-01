package org.my.hrank.algorithms.dynamic_programming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TheChangeCoinProblemSolution {

    // Complete the getWays function below.
    static long getWays(long n, long[] steps) {
        long entireTest = System.currentTimeMillis();
        if (n < 0) {
            return 0;
        }
        if (steps.length == 0 || n == 0) {
            return 1;
        }
        HashSet<Hop>[] road = new HashSet[(int) n + 1];

        for (int i = 0; i < road.length; i++) {
            road[i] = new HashSet<>();
        }
        road[0].add(new Hop(0, 0));
        long totalTime = 0;
        long current = 0;
        for (int i = 0; i < road.length; i++) {
            if (i > 0) {
                road[i - 1] = null;
            }
            for (Hop hop : road[i]) {
                for (int j = 0; j < steps.length; j++) {
                    current = System.currentTimeMillis();
                    Hop nextHop = new Hop(hop.numberOfHops + 1, steps[j]);
//                    nextHop.chain.addAll(hop.chain);
//                    nextHop.chain.add(nextHop.value);
//                    Collections.sort(nextHop.chain);
                    nextHop.chain = binaryInsert(hop.chain, nextHop.value);
                    totalTime += System.currentTimeMillis() - current;
                    if (i + steps[j] < road.length) {
                        road[i + (int) steps[j]].add(nextHop);
                    }
                }
            }
        }


        HashSet<Hop> hops = road[road.length - 1];
//        HashSet<ArrayList<Long>> result = new HashSet<>();
//        for (Hop hop : hops) {
//            Collections.sort(hop.chain);
//            result.add(hop.chain);
//        }
        System.out.println("Total time in sorting is " + totalTime);
        System.out.println("Entire test " + (System.currentTimeMillis() - entireTest));

//        return result.size();
        return hops.size();

    }

    public static ArrayList<Long> binaryInsert(ArrayList<Long> values, long value) {
        ArrayList<Long> result = new ArrayList<>(values.size() + 1);
        result.addAll(values);
        if (result.size() == 0) {
            result.add(value);
            return result;
        }
        if (result.size() == 1) {
            if (value >= result.get(0)) {
                result.add(value);
            } else {
                result.add(0, value);
            }
            return result;
        }
        int left = 0;
        int right = result.size() - 1;
        int middle = -1;
        int position = -1;
        while (position == -1) {

            if (right - left == 1) {
                if (value <= result.get(right)) {
                    position = right;
                }
                if (value > result.get(right)) {
                    position = right + 1;
                }
                if (value < result.get(left)) {
                    position = left;
                }
            }
            middle = (left + right + 1) / 2;
            if (value > result.get(middle)) {
                left = middle;
            }
            if (value < result.get(middle)) {
                right = middle;
            }
            if (value == result.get(middle)) {
                position = middle + 1;
                break;
            }

        }
        result.add(position, value);

        return result;
    }

    public static class Hop {
        long numberOfHops;
        long value;
        ArrayList<Long> chain = new ArrayList<>();

        public Hop(long index, long value) {
            this.numberOfHops = index;
            this.value = value;
//            chain.add(value);
        }

        @Override
        public String toString() {
            return "Hop{" +
                    "numberOfHops=" + numberOfHops +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Hop hop = (Hop) o;
            return Objects.equals(chain, hop.chain);
        }

        @Override
        public int hashCode() {

            return Objects.hash(chain);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);
        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }

}
