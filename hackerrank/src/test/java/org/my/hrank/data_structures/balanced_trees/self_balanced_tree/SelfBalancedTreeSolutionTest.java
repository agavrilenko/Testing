package org.my.hrank.data_structures.balanced_trees.self_balanced_tree;

import org.hamcrest.collection.IsArrayContainingInOrder;
import org.my.hrank.AbstractTest;
import org.my.hrank.utils.TreesUtils;

import java.util.Arrays;
import java.util.Scanner;

public class SelfBalancedTreeSolutionTest extends AbstractTest {


    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) throws InstantiationException, IllegalAccessException {
        int n = Integer.parseInt(inScanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = inScanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }
        Solution.Node root = (Solution.Node) TreesUtils.buildTree(indexes, Solution.Node.class);
        int val = inScanner.nextInt();


        Solution.Node actualNode = Solution.insert(root, val);
        Integer[] actual = TreesUtils.traverseTree(actualNode);

        Integer[] expected = new Integer[n];

        for (int i = 0; i < expected.length; i++) {
            String line = outScanner.nextLine();
            String[] dataSt = line.split(" ");
            expected[i] = Integer.valueOf(dataSt[i]);
        }

        collector.checkThat("Test failed for " + absolutePath, actual, IsArrayContainingInOrder.<Object>arrayContaining(expected));


    }
}