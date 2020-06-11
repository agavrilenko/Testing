package org.my.hrank.algorithms.dynamic_programming.four_sum;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class FourSum2Test {
    private FourSum2 solution = new FourSum2();

    @DataProvider
    public static Object[][] data() {

        return new Object[][]{
                {new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}, 2},
                {new int[]{0, 1, 2}, new int[]{1, 2, 0}, new int[]{0, -1, -2}, new int[]{-2, 0, -1}, 19},
                {new int[]{7, 7, 7, 0}, new int[]{7, 0, 7, 1}, new int[]{7, 2, 0, 3}, new int[]{7, 0, 7, -3}, 3},
        };
    }

    @Test
    @UseDataProvider("data")
    public void test(int[] a, int[] b, int[] c, int[] d, int expeted) {
        Assert.assertEquals(expeted, solution.fourSumCount(a, b, c, d));
    }
}