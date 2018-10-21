package org.my.hrank.algorithms.implementation.almost_sorted;

import org.hamcrest.collection.IsArrayContainingInOrder;
import org.my.hrank.AbstractTest;

import java.util.LinkedList;
import java.util.Scanner;

import static org.my.hrank.algorithms.implementation.almost_sorted.AlmostSortedSolution.getResult;

public class AlmostSortedSolutionTest extends AbstractTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {
        int n = inScanner.nextInt();
        inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = inScanner.nextLine().split(" ");
        inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        LinkedList<String> actual = getResult(arr);
        LinkedList<String> expectedList = new LinkedList<>();
        while (outScanner.hasNextLine()) {
            expectedList.add(outScanner.nextLine());
        }
        collector.checkThat("Test failed for " + absolutePath, actual.toArray(), IsArrayContainingInOrder.arrayContaining(expectedList.toArray()));

    }
}