package org.my.hrank.algorithms.dynamic_programming;

import org.hamcrest.core.Is;
import org.my.hrank.AbstractPackageTest;

import java.util.Scanner;

import static org.junit.Assert.*;
import static org.my.hrank.algorithms.dynamic_programming.SubstringDiffSolution.substringDiff;

public class SubstringDiffSolutionTest extends AbstractPackageTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {
        int t = inScanner.nextInt();
        inScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] kS1S2 = inScanner.nextLine().split(" ");

            int k = Integer.parseInt(kS1S2[0]);

            String s1 = kS1S2[1];

            String s2 = kS1S2[2];

            int result = substringDiff(k, s1, s2);
            int expected = Integer.parseInt(outScanner.nextLine().trim());
            collector.checkThat("Test failed for " + absolutePath, result, Is.is(expected));
        }

    }
}