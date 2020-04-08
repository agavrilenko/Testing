package org.my.hrank.algorithms.dynamic_programming.levenstein_distance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MinDistanceSolutionTest {

    private String s1;
    private String s2;
    private int answer;
    private MinDistanceSolution solution;

    @Before
    public void init() {

        solution = new MinDistanceSolution();
    }

    public MinDistanceSolutionTest(String s1, String s2, int answer) {
        this.s1 = s1;
        this.s2 = s2;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Collection params() {

        return Arrays.asList(new Object[][]{
                {"horse", "ros", 3},
                {"intention", "execution", 5},
                {"abcdef", "azced", 3},
                {"saturday", "sunday", 3}

        });
    }

    @Test
    public void test() {

        Assert.assertEquals(answer, solution.minDistance(s1, s2));
    }
}