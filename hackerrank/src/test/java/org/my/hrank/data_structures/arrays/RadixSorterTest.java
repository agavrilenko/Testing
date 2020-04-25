package org.my.hrank.data_structures.arrays;

import org.junit.Test;

public class RadixSorterTest extends AbstractSorterTest {

    public RadixSorterTest(int[] src, int[] out) {
        this.src = src;
        this.out = out;
    }

    @Override
    public Sorter getSorter() {
        return new RadixSorter();
    }

    @Test
    public void test() {
        super.test();
    }
}