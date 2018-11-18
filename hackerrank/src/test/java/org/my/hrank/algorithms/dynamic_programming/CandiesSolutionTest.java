package org.my.hrank.algorithms.dynamic_programming;

import org.hamcrest.core.Is;
import org.my.hrank.AbstractPackageTest;

import java.util.Scanner;

import static org.junit.Assert.*;
import static org.my.hrank.algorithms.dynamic_programming.CandiesSolution.candies;

public class CandiesSolutionTest extends AbstractPackageTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {
        int n = inScanner.nextInt();
        inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = inScanner.nextInt();
            inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);
        long expected = Long.parseLong(outScanner.nextLine().trim());
        collector.checkThat("Test failed for " + absolutePath, result, Is.is(expected));

    }
}