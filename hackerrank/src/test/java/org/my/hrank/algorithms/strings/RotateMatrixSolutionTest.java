package org.my.hrank.algorithms.strings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RotateMatrixSolutionTest {
    private int[][] in;
    private int[][] out;
    private RotateMatrixSolution solution;

    @Before
    public void init() {
        solution = new RotateMatrixSolution();
    }

    @Test
    public void testSimple() {
        in = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        out = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}};
        Assert.assertArrayEquals(out, solution.rotate(in));

    }

    @Test
    public void testSimple1() {
        in = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        out = new int[][]
                {{15, 13, 2, 5},
                 {14, 3, 4, 1},
                 {12, 6, 8, 9},
                 {16, 7, 10, 11}};
        Assert.assertArrayEquals(out, solution.rotate(in));

    }
}