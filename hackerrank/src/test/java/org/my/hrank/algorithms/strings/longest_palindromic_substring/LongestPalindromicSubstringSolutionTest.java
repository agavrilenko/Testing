package org.my.hrank.algorithms.strings.longest_palindromic_substring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LongestPalindromicSubstringSolutionTest {
    private String in;
    private String out;
    private LongestPalindromicSubstringSolution solution;

    public LongestPalindromicSubstringSolutionTest(String in, String out) {
        this.in = in;
        this.out = out;
    }

    @Before
    public void init() {

        solution = new LongestPalindromicSubstringSolution();
    }

    @Parameterized.Parameters
    public static Collection params() {

        return Arrays.asList(new Object[][]{
                {"babad", "bab"},
                {"babab", "babab"},
                {"fbabab", "babab"},
                {"bababf", "babab"},
                {"fbababs", "babab"},
                {"cbbd", "bb"},
                {"cabbad", "abba"},
                {"abbad", "abba"},
                {"aasabba", "abba"},
                {"", ""},

        });

    }

    @Test
    public void test() {

        Assert.assertEquals(out, solution.longestPalindrome(in));
    }
}