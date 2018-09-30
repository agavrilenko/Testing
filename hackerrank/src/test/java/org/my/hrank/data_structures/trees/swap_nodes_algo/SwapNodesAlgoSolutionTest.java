package org.my.hrank.data_structures.trees.swap_nodes_algo;

import org.hamcrest.collection.IsArrayContainingInOrder;
import org.my.hrank.AbstractTest;

import java.util.Arrays;
import java.util.Scanner;

import static org.my.hrank.data_structures.trees.swap_nodes_algo.Solution.swapNodes;

public class SwapNodesAlgoSolutionTest extends AbstractTest {


    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) {
        int n = Integer.parseInt(inScanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = inScanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(inScanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(inScanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] expected = new int[queries.length][n];
        for (int i = 0; i < expected.length; i++) {
            String line = outScanner.nextLine();
            String[] dataSt = line.split(" ");
            expected[i] = Arrays.stream(dataSt).mapToInt(Integer::parseInt).toArray();
        }
//        IntStream.range(1, 100).reduce((x, y) -> x + y);

        int[][] result = swapNodes(indexes, queries);

        collector.checkThat("Test failed for " + absolutePath, result, IsArrayContainingInOrder.<Object>arrayContaining(expected));


    }
}