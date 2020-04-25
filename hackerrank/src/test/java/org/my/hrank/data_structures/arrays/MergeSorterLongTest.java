package org.my.hrank.data_structures.arrays;

import org.junit.Test;

public class MergeSorterLongTest extends AbstractSorterLongTest {
    @Override
    public Sorter getSorder() {
        return new MergeSorter();
    }

    public MergeSorterLongTest(int n) {
        this.n = n;
    }

    @Test
    public void test() {
        super.test();
        //Count: 1000000
        //init: 0
        //shuffle: 0
        //sort: 0
        //Count: 10000000
        //init: 0
        //shuffle: 1
        //sort: 7
        //Count: 100000000
        //init: 1
        //shuffle: 16
        //sort: 75
        //Count: 500000000
        //init: 8
        //shuffle: 105
        //sort: 472
    }
}
