package org.my.hrank.data_structures.arrays.top_k_freq_elements;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(DataProviderRunner.class)
public class TopKFreqElementsTest {
    private TopKFreqElements solution = new TopKFreqElements();

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}},
                {new int[]{1}, 1, new int[]{1}},
        };

    }

    @Test
    @UseDataProvider("data")
    public void test(int[] nums, int k, int[] expected) {
        int[] actuals = solution.topKFrequent(nums, k);
        Arrays.sort(actuals);
        Assert.assertArrayEquals(expected, actuals);
    }


}