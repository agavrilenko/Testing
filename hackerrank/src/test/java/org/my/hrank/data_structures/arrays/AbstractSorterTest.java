package org.my.hrank.data_structures.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public abstract class AbstractSorterTest {

    protected int[] src;
    protected int[] out;
    protected Sorter sorter;

    @Before
    public void init() {

        sorter = getSorter();
    }

    public abstract Sorter getSorter();


    @Parameterized.Parameters
    public static Collection params() {

        return Arrays.asList(new Object[][]{
                {new int[]{2, 1}, new int[]{1, 2}},
                {new int[]{6, 5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5, 6}},
                {new int[]{1, 2, 2, 1}, new int[]{1, 1, 2, 2}},
                {new int[]{3, 2, 1}, new int[]{1, 2, 3}},
                {new int[]{3, 2, 3, 1}, new int[]{1, 2, 3, 3}},
                {new int[]{1, 2, 3}, new int[]{1, 2, 3}},
                {new int[]{3, 3, 3, 3, 3, 2, 3, 1}, new int[]{1, 2, 3, 3, 3, 3, 3, 3}},
                {new int[]{7, 3, 11, 2, 8, 4, 5, 10, 6, 9, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}},

        });
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(out, sorter.sort(src));

    }
}