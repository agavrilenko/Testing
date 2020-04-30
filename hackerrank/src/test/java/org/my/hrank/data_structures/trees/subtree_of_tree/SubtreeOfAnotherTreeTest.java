package org.my.hrank.data_structures.trees.subtree_of_tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.my.hrank.data_structures.trees.TreeUtils;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SubtreeOfAnotherTreeTest {
    private int[] p;
    private int[] q;
    private boolean answer;
    private SubtreeOfAnotherTree solution;

    public SubtreeOfAnotherTreeTest(int[] p, int[] q, boolean answer) {
        this.p = p;
        this.q = q;
        this.answer = answer;
    }


    @Before
    public void init() {
        solution = new SubtreeOfAnotherTree();
    }

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 4, 5, 1, 2}, new int[]{4, 1, 2}, true},
                {new int[]{3, 4, 5, 1, 2, -1, -1, -1, -1, 0}, new int[]{4, 1, 2}, false},
                {new int[]{3, 4, 5, 1, 2, -1, -1, 0}, new int[]{4, 1, 2}, false},
                {new int[]{1, 1}, new int[]{1}, true},
        });
    }

    @Test
    public void test() {
        Assert.assertEquals(answer, solution.isSubtree(TreeUtils.buildTree(p), TreeUtils.buildTree(q)));
    }
}