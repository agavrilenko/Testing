package org.my.hrank.algorithms.dynamic_programming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class TheChangeCoinProblemSolution {

    // Complete the getWays function below.
    static long getWays(long n, long[] steps) {

        if (n < 0) {
            return 0;
        }
        if (steps.length == 0 || n == 0) {
            return 1;
        }
        ArrayList<Hop>[] road = new ArrayList[(int) n + 1];

        for (int i = 0; i < road.length; i++) {
            road[i] = new ArrayList<>();
        }
//        final value should be finish, but we have offset of start value
//        to decrease number of computations
        road[0].add(new Hop(0, 0));
        for (int i = 0; i < road.length; i++) {
            for (Hop hop : road[i]) {
                for (int j = 0; j < steps.length; j++) {
                    Hop nextHop = new Hop(hop.numberOfHops + 1, steps[j]);
                    nextHop.chain.addAll(hop.chain);
                    if (i + steps[j] < road.length) {
                        road[i + (int) steps[j]].add(nextHop);
                    }
                }
            }
        }

        ArrayList<Hop> hops = road[road.length - 1];
        HashSet<ArrayList<Long>> result = new HashSet<>();
        for (Hop hop : hops) {
            Collections.sort(hop.chain);
            result.add(hop.chain);
        }

        return result.size() > 0 ? result.size() : 1;

    }

    public static class Hop {
        long numberOfHops;
        long value;
        ArrayList<Long> chain = new ArrayList<>();

        public Hop(long index, long value) {
            this.numberOfHops = index;
            this.value = value;
            chain.add(value);
        }

        @Override
        public String toString() {
            return "Hop{" +
                    "numberOfHops=" + numberOfHops +
                    ", value=" + value +
                    '}';
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

        bufferedWriter.close();

        scanner.close();
    }

}
