package org.my.hrank.data_structures.arrays;

import org.junit.Assert;
import org.junit.Test;

public class MergeSorterTest extends AbstractSorterTest {

    public MergeSorterTest(int[] src, int[] out) {
        this.src = src;
        this.out = out;
    }

    @Override
    public Sorter getSorter() {
        return new MergeSorter();
    }

    @Test
    public void test() {
        super.test();
    }
}