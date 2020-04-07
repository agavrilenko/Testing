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
    public void testSimple3() {
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
    public void testSimple4() {
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

    @Test
    public void testSimple5() {
        in = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
        out = new int[][]
                {{21, 16, 11, 6, 1},
                        {22, 17, 12, 7, 2},
                        {23, 18, 13, 8, 3},
                        {24, 19, 14, 9, 4},
                        {25, 20, 15, 10, 5}
                };
        Assert.assertArrayEquals(out, solution.rotate(in));

    }
}