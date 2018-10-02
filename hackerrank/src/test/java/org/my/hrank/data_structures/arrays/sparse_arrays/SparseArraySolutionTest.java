package org.my.hrank.data_structures.arrays.sparse_arrays;

import org.hamcrest.collection.IsArrayContainingInOrder;
import org.junit.Test;
import org.my.hrank.AbstractTest;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class SparseArraySolutionTest extends AbstractTest {

    @Test
    public void testStringParsing() throws Exception {
        this.test();

    }

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) {
        int dictSize = Integer.valueOf(inScanner.nextLine());
        String[] strings = new String[dictSize];
        for (int i = 0; i < dictSize; i++) {
            strings[i] = inScanner.nextLine();
        }
        int querySize = Integer.valueOf(inScanner.nextLine());
        String[] queries = new String[querySize];
        Integer[] exp = new Integer[querySize];
        for (int i = 0; i < querySize; i++) {
            queries[i] = inScanner.nextLine();
            exp[i] = Integer.valueOf(outScanner.nextLine());
        }
        int[] actuals = Solution.matchingStrings(strings, queries);
        Integer[] act = new Integer[actuals.length];
        for (int i = 0; i < actuals.length; i++) {
            act[i] = actuals[i];
        }
        collector.checkThat("Test failed for " + absolutePath, act, IsArrayContainingInOrder.<Object>arrayContaining(exp));
    }
}