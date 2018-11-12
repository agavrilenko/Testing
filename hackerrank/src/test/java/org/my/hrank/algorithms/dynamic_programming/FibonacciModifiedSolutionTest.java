package org.my.hrank.algorithms.dynamic_programming;

import org.hamcrest.core.Is;
import org.my.hrank.AbstractPackageTest;

import java.util.Scanner;

import static org.junit.Assert.*;
import static org.my.hrank.algorithms.dynamic_programming.FibonacciModifiedSolution.fibonacciModified;

public class FibonacciModifiedSolutionTest extends AbstractPackageTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {
        String[] t1T2n = inScanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        //convert to String
        String result = fibonacciModified(t1, t2, n);
        String expected = outScanner.nextLine().trim();
        collector.checkThat("Test failed for " + absolutePath, result, Is.is(expected));
    }
}