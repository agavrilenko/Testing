package org.my.hrank.data_structures.trees.balanced_binary_tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.my.hrank.data_structures.trees.TreeUtils;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IsBinaryTreeBalancedSolutionTest {

    private int[] in;
    private boolean depth;
    private IsBinaryTreeBalancedSolution solution;

    public IsBinaryTreeBalancedSolutionTest(int[] in, boolean depth) {
        this.in = in;
        this.depth = depth;
    }

    @Before
    public void init() {
        solution = new IsBinaryTreeBalancedSolution();
    }

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {new int[]{-1, 3, 9, 20, -1, -1, 15, 17}, true},
                {new int[]{-1, 1, 2, 2, 3, 3, -1, -1, 4, 4}, false},
                {new int[]{-1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, -1, -1, 5, 5}, true},


        });

    }

    @Test
    public void test() {
        Assert.assertEquals(depth, solution.isBalanced(TreeUtils.buildTree(in)));

    }
}