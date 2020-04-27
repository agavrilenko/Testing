package org.my.hrank.data_structures.trees.sorted_array_to_bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SortedArrayToBSTSolutionTest {

    private int in[];
    private int out[];
    private SortedArrayToBSTSolution solution;

    public SortedArrayToBSTSolutionTest(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    @Before
    public void init() {
        solution = new SortedArrayToBSTSolution();
    }

    @Parameterized.Parameters
    public static Collection params() {

        return Arrays.asList(new Object[][]{
                {new int[]{-10, -3, 0, 5, 9}, new int[]{0, -10, -3, 5, 9}},
                {new int[]{1, 2, 3, 4, 5}, new int[]{3, 1, 2, 4, 5}},
        });

    }

    @Test
    public void test() {

        SortedArrayToBSTSolution.TreeNode node = solution.sortedArrayToBST(in);
        int[] storage = new int[in.length];
        solution.inOrder(node, storage, 0);
        Assert.assertArrayEquals(out, storage);

    }

}