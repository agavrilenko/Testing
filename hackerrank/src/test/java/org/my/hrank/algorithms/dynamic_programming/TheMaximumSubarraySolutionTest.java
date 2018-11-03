package org.my.hrank.algorithms.dynamic_programming;

import org.hamcrest.collection.IsArrayContainingInOrder;
import org.my.hrank.AbstractPackageTest;
import org.my.hrank.utils.ArrayUtils;

import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.my.hrank.algorithms.dynamic_programming.TheMaximumSubarraySolution.maxSubarray;

public class TheMaximumSubarraySolutionTest extends AbstractPackageTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {
        int t = inScanner.nextInt();
        inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = inScanner.nextInt();
            inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = inScanner.nextLine().split(" ");
            inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);
            List<Integer> expectedList = ArrayUtils.readArray(outScanner.nextLine(), Integer.class);
            Integer[] expected = expectedList.toArray(new Integer[]{});

            Integer[] act = new Integer[result.length];
            for (int i = 0; i < result.length; i++) {
                act[i] = result[i];
            }
            collector.checkThat("Test failed for " + absolutePath, act, IsArrayContainingInOrder.<Object>arrayContaining(expected));
        }
    }
}