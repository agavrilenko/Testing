package org.my.hrank.data_structures.trees.path_sum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.my.hrank.data_structures.trees.TreeUtils;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PathToSumTest {

    private int[] tree;
    private int sum;
    private int answer;
    private PathToSum solution;

    public PathToSumTest(int[] p, int q, int answer) {
        this.tree = p;
        this.sum = q;
        this.answer = answer;
    }

    @Before
    public void init() {

        solution = new PathToSum();
    }

    @Parameterized.Parameters
    public static Collection params() {

        return Arrays.asList(new Object[][]{
                {new int[]{10, 5, -3, 3, 2, -1, 11, 3, -2, -1, 1}, 8, 3},

        });
    }

    @Test
    public void test() {

        Assert.assertEquals(answer, solution.pathSum(TreeUtils.buildTree(tree), sum));

    }
}