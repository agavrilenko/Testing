package org.my.hrank.algorithms.dynamic_programming;

import org.hamcrest.core.Is;
import org.my.hrank.AbstractPackageTest;

import java.util.Scanner;

import static org.junit.Assert.*;
import static org.my.hrank.algorithms.dynamic_programming.SherlockAndCostSolution.cost;

public class SherlockAndCostSolutionTest extends AbstractPackageTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {
        int t = inScanner.nextInt();
        inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = inScanner.nextInt();
            inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] B = new int[n];

            String[] BItems = inScanner.nextLine().split(" ");
            inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            int result = cost(B);
            int expected = Integer.parseInt(outScanner.nextLine().trim());
            collector.checkThat("Test failed for " + absolutePath, result, Is.is(expected));

        }
    }
}