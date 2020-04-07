package org.my.hrank.algorithms.strings.urlify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class URLifySolutionTest {

    private String in;
    private String out;
    URLifySolution solution;

    public URLifySolutionTest(String in, String out) {
        this.in = in;
        this.out = out;
    }

    @Before
    public void init() {
        solution = new URLifySolution();
    }


    @Parameterized.Parameters
    public static Collection values() {

        return Arrays.asList(new Object[][]{
                {"Mr John Smith    ", "Mr%20John%20Smith"},
                {"Mr John Smi th      ", "Mr%20John%20Smi%20th"},
        });

    }

    @Test
    public void test() {
        Assert.assertEquals(out, solution.getString(in));
    }
}