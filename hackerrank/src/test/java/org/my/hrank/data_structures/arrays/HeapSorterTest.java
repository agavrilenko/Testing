package org.my.hrank.data_structures.arrays;

import org.junit.Test;

public class HeapSorterTest extends AbstractSorterTest {

    public HeapSorterTest(int[] src, int[] out) {
        this.src = src;
        this.out = out;
    }
    @Override
    public Sorter getSorter() {
        return new HeapSorter();
    }

    @Test
    public void test() {
        super.test();
    }
}