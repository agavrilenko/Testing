package org.my.hrank.algorithms.strings.camel_case_matching;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class CamelCaseMatchingTest {
    private CamelCaseMatching solution = new CamelCaseMatching();

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB", Arrays.asList(true, false, true, true, false)},
                {new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa", Arrays.asList(true, false, true, false, false)},
                {new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBaT", Arrays.asList(false, true, false, false, false)},
        };
    }

    @Test
    @UseDataProvider("data")
    public void test(String[] queries, String pattern, List<Boolean> expeted) {
        Assert.assertArrayEquals(expeted.toArray(), solution.camelMatch(queries, pattern).toArray());
    }

}