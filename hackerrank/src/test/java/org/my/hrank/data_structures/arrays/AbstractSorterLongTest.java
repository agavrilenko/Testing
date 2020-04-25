package org.my.hrank.data_structures.arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;

@RunWith(Parameterized.class)
public abstract class AbstractSorterLongTest {
    protected Sorter sorter;
    protected int n;
    protected int size = 1_000_000_000;

    public abstract Sorter getSorder();

    @Parameterized.Parameters(name = "count {0}")
    public static Collection params() {
        return Arrays.asList(new Object[][]{
                {1_000_000},
                {10_000_000},
                {100_000_000},
                {500_000_000},
//                {1_000_000_000},

        });

    }

    @Test
    public void test() {
        size = n;
        System.out.println("Count: " + size);
        long start = System.currentTimeMillis();

        int[] in = IntStream.range(0, size).toArray();
        int[] out = new int[size];
        System.arraycopy(in, 0, out, 0, size);

        System.out.println("init: " + ((System.currentTimeMillis() - start) / 1000));
        start = System.currentTimeMillis();
        Random r = new Random();
        int idx;
        int t;
        for (int i = size - 1; i > 0; i--) {
            idx = r.nextInt(i);
            t = in[i];
            in[i] = in[idx];
            in[idx] = t;
        }
        System.out.println("shuffle: " + ((System.currentTimeMillis() - start) / 1000));
        start = System.currentTimeMillis();
        Assert.assertArrayEquals(out, getSorder().sort(in));
//        Assert.assertNotNull(sorter.sort(in));
        System.out.println("sort: " + ((System.currentTimeMillis() - start) / 1000));

    }

}