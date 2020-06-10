package org.my.hrank.algorithms.dynamic_programming.four_sum;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

@RunWith(DataProviderRunner.class)
public class FourSumTest {

    private FourSum solution = new FourSum();

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 0, -1, 0, -2, 2}, 0, asList(asList(-1, 0, 0, 1), asList(-2, -1, 1, 2), asList(-2, 0, 0, 2))},
        }

                ;
    }

    @Test
    @UseDataProvider("data")
    public void testH(int[] nums, int target, List<List<Integer>> expected) {

        List<List<Integer>> result = solution.fourSum(nums, target);
        Assert.assertEquals("Sizes are not matching", expected.size(), result.size());
        for (List<Integer> list : result) {
            Collections.sort(list);
            Assert.assertTrue(expected.contains(list));
        }
    }
}