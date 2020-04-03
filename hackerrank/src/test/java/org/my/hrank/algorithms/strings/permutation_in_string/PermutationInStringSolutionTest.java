package org.my.hrank.algorithms.strings.permutation_in_string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PermutationInStringSolutionTest {
    private String first;
    private String second;
    private boolean isPermutation;
    PermutationInStringSolution solution;

    @Before
    public void init() {
        solution = new PermutationInStringSolution();

    }

    public PermutationInStringSolutionTest(String first, String second, boolean isPermutation) {
        this.first = first;
        this.second = second;
        this.isPermutation = isPermutation;
    }

    @Parameterized.Parameters
    public static Collection values() {
        return Arrays.asList(new Object[][]{
                {"adc", "dcda", true},
                {"cb", "abcd", true},
                {"ab", "eidbaooo", true},
                {"oo", "eidbaooo", true},
                {"ab", "eidboaoo", false}
        });
    }

    @Test

    public void test() {
        Assert.assertEquals(isPermutation, solution.checkInclusion(first, second));

    }
}