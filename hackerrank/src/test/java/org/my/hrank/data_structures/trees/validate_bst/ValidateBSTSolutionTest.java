package org.my.hrank.data_structures.trees.validate_bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.my.hrank.utils.TreeUtils;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ValidateBSTSolutionTest {
    private int[] in;
    private boolean depth;
    private ValidateBSTSolution solution;

    public ValidateBSTSolutionTest(int[] in, boolean depth) {
        this.in = in;
        this.depth = depth;
    }

    @Before
    public void init() {
        solution = new ValidateBSTSolution();
    }

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {new int[]{ 2, 1, 3}, true},
                {new int[]{ 1, 1}, false},
                {new int[]{ 5, 1, 4, -1, -1, 3, 6}, false},


        });

    }

    @Test
    public void test() {
        Assert.assertEquals(depth, solution.isValidBST(TreeUtils.buildTree(in)));

    }
}