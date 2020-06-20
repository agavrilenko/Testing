package org.my.hrank.data_structures.trees;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.my.hrank.utils.TreeUtils;

@RunWith(DataProviderRunner.class)
public class SumOfNodesWithEvenValuedGrandparentTest {
    private SumOfNodesWithEvenValuedGrandparent solution = new SumOfNodesWithEvenValuedGrandparent();

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{6, 7, 8, 2, 7, 1, 3, 9, -1, 1, 4, -1, -1, -1, 5}, 18},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17}, 71}

        };

    }

    @Test
    @UseDataProvider("data")
    public void test(int[] src, int expected) {
        Assert.assertEquals(expected, solution.sumEvenGrandparent(TreeUtils.buildTree(src)));

    }

}