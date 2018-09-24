package org.my.hrank.data_structures.trees.bst_least_common_ancestor;

import org.hamcrest.core.Is;
import org.my.hrank.AbstractTest;

import java.util.Scanner;

import static org.my.hrank.data_structures.trees.bst_least_common_ancestor.Solution.insert;
import static org.my.hrank.data_structures.trees.bst_least_common_ancestor.Solution.lca;

public class LCASolutionTest extends AbstractTest {


    @Override
    public void testAndAssert(Scanner inScanner, Scanner outScanner, String absolutePath) {

        int t = inScanner.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = inScanner.nextInt();
            root = insert(root, data);
        }
        int v1 = inScanner.nextInt();
        int v2 = inScanner.nextInt();
        int expected = outScanner.nextInt();
        collector.checkThat("Failed on " + absolutePath, lca(root, v1, v2).data, Is.is(expected));
    }
}