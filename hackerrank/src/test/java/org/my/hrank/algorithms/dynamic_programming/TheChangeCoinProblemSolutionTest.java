package org.my.hrank.algorithms.dynamic_programming;

import org.hamcrest.core.Is;
import org.my.hrank.AbstractPackageTest;

import java.util.Scanner;

import static org.my.hrank.algorithms.dynamic_programming.TheChangeCoinProblemSolution.getWays;

public class TheChangeCoinProblemSolutionTest extends AbstractPackageTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {
        String[] nm = inScanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];

        String[] cItems = inScanner.nextLine().split(" ");
        inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long expected = Long.parseLong(outScanner.nextLine().trim());
        long actual = getWays(n, c);

        collector.checkThat(getMessage(absolutePath), actual, Is.is(expected));

    }
}