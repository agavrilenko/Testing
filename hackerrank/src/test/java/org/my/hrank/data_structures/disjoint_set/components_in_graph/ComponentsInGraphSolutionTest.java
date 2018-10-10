package org.my.hrank.data_structures.disjoint_set.components_in_graph;

import org.hamcrest.collection.IsArrayContainingInOrder;
import org.my.hrank.AbstractTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.my.hrank.data_structures.disjoint_set.components_in_graph.Solution.componentsInGraph;

public class ComponentsInGraphSolutionTest extends AbstractTest {

    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws Exception {

        int n = Integer.parseInt(inScanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = inScanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }
        int[] result = componentsInGraph(gb);
        Integer[] actual = new Integer[result.length];
        for (int i = 0; i < result.length; i++) {
            actual[i] = result[i];
        }
        Integer[] expected = new Integer[2];
        String[] values = outScanner.nextLine().split(" ");
        for (int i = 0; i < values.length; i++) {
            expected[i] = Integer.valueOf(values[i]);
        }
        collector.checkThat("Test failed for " + absolutePath, actual, IsArrayContainingInOrder.<Object>arrayContaining(expected));
    }
}