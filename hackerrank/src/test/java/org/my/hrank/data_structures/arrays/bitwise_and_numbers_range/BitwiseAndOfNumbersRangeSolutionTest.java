package org.my.hrank.data_structures.arrays.bitwise_and_numbers_range;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BitwiseAndOfNumbersRangeSolutionTest {

    private int n;
    private int m;
    private int out;
    private BitwiseAndOfNumbersRangeSolution solution;

    public BitwiseAndOfNumbersRangeSolutionTest(int m, int n, int out) {
        this.n = n;
        this.m = m;
        this.out = out;
    }

    @Before
    public void init(){
        solution = new BitwiseAndOfNumbersRangeSolution();
    }

    @Parameterized.Parameters
    public static Collection params() {

        return Arrays.asList(new Object[][]{
                {5, 7, 4},
                {0, 1, 0},
                {5, 8, 0},
                {0, 2147483647, 0},
        });
    }

    @Test
    public void test() {

        Assert.assertEquals(out, solution.rangeBitwiseAnd(m, n));

    }
}