package org.my.hrank.data_structures.trees.bst_least_common_ancestor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.my.hrank.data_structures.trees.TreeNode;
import org.my.hrank.data_structures.trees.TreeUtils;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LowestCommonAncestorSolutionTest {
    private int[] in;
    private TreeNode node1;
    private TreeNode node2;
    private TreeNode out;
    private LowestCommonAncestorSolution solution;

    public LowestCommonAncestorSolutionTest(int[] in, TreeNode node1, TreeNode node2, TreeNode node) {
        this.in = in;
        this.node1 = node1;
        this.node2 = node2;
        this.out = node;
    }

    @Before

    public void init() {
        solution = new LowestCommonAncestorSolution();

    }

    @Parameterized.Parameters
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4}, new TreeNode(5), new TreeNode(1), new TreeNode(3)},
                {new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4}, new TreeNode(5), new TreeNode(4), new TreeNode(5)},


        });

    }

    @Test
    public void test() {

        Assert.assertEquals(out, solution.lowestCommonAncestor(TreeUtils.buildTree(in), node1, node2));


    }

}