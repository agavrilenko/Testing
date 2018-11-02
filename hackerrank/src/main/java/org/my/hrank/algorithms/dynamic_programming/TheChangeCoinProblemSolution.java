package org.my.hrank.algorithms.dynamic_programming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TheChangeCoinProblemSolution {

    // Complete the getWays function below.
    static long getWays(long n, long[] steps) {
        if (n < 0) {
            return 0;
        }
        if (steps.length == 0 || n == 0) {
            return 1;
        }
//        result[0]=1; // init base case n=0
        // go thru coins 1-by-1 to build up result[] dynamically
        // just need to consider cases where sum j>=steps[i]
        long[] result = new long[(int) n + 1];
        result[0] = 1;
//        for (int i = 0; i < steps.length; i++) {
//            for (int j = (int) steps[i]; j <= n; j++) {
        // find result to get sum j given value steps[i]
        // it consists of those found earlier plus
        // new ones.
        // E.g. if steps[]=1,2,3... and steps[i]=3,j=5,
        //      new ones will now include '3' with
        //      result[2] = 2, that is:
        //      '3' with '2', '3' with '1'+'1'
//                result[j] += result[j - (int) steps[i]];
//            }
//        }
        //take coins one by one and count next sum as sum of current and next.
        //
        for (int j = 0; j < steps.length; j++) {
            for (int i = 0; i <= n; i++) {
                if (i + (int) steps[j] <= n) {
                    result[i + (int) steps[j]] = result[i] + result[i + (int) steps[j]];
                }
            }
        }


        return result[(int) n];
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
