package org.my.hrank.data_structures.arrays.binary_subarray_with_sum;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class BinarySubarraysWithSumTest {
    private BinarySubarraysWithSum solution = new BinarySubarraysWithSum();

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 0, 1, 0, 1}, 2, 4},
                {new int[]{0, 0, 1, 0}, 1, 6},
                {new int[]{0, 0, 0, 0, 1}, 1, 5},
                {new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0}, 2, 12},
                {new int[]{0, 0, 0, 0, 0}, 0, 15},
                {new int[]{0, 0, 1, 0, 1, 0, 0, 0}, 0, 10},
        };
    }

    @Test
    @UseDataProvider("data")
    public void testSum(final int[] input, final int sum, final int expected) {
        assertEquals(expected, solution.numSubarraysWithSum(input, sum));
    }
}