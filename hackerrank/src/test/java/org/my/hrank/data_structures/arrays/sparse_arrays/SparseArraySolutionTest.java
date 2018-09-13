package org.my.hrank.data_structures.arrays.sparse_arrays;

import org.hamcrest.Matcher;
import org.hamcrest.collection.IsArray;
import org.hamcrest.collection.IsArrayContaining;
import org.hamcrest.collection.IsArrayContainingInOrder;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.my.hrank.AbstractTest;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class SparseArraySolutionTest extends AbstractTest {

    @Test
    public void testStringParsing() throws FileNotFoundException {
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
        AtomicInteger ind = new AtomicInteger(0);
        Arrays.stream(act).
                forEach(i -> i = actuals[ind.getAndIncrement()]);
        collector.checkThat("Test failed for " + absolutePath, act, IsArrayContainingInOrder.<Object>arrayContaining(exp));
    }
}