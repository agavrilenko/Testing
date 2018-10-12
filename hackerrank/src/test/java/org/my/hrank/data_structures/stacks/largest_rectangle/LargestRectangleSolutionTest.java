package org.my.hrank.data_structures.stacks.largest_rectangle;

import org.hamcrest.core.IsEqual;
import org.my.hrank.AbstractTest;

import java.util.Scanner;

import static org.junit.Assert.*;
import static org.my.hrank.data_structures.stacks.largest_rectangle.Solution.largestRectangle;

public class LargestRectangleSolutionTest extends AbstractTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {
        int n = inScanner.nextInt();
        inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = inScanner.nextLine().split(" ");
        inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long expected = Long.parseLong(outScanner.nextLine().trim());
        long result = largestRectangle(h);
        collector.checkThat(getMessage(absolutePath), result, IsEqual.equalTo(expected));
    }
}