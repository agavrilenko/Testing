package org.my.hrank.data_structures.arrays;

import org.junit.Test;

public class QuickSorterTest extends AbstractSorterTest {

    public QuickSorterTest(int[] src, int[] out) {
        this.src = src;
        this.out = out;
    }

    @Override
    public Sorter getSorter() {
        return new QuickSorter();
    }

    @Test
    public void test() {
        super.test();
    }
}