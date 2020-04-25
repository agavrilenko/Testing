package org.my.hrank.data_structures.arrays;

import org.junit.Test;

public class HeapSorterLongTest extends AbstractSorterLongTest {
    @Override
    public Sorter getSorder() {
        return new HeapSorter();
    }

    public HeapSorterLongTest(int n) {
        this.n = n;
    }

    @Test
    public void test() {
        super.test();
    }

    //Count: 1000000
    //init: 0
    //shuffle: 0
    //sort: 1
    //Count: 10000000
    //init: 0
    //shuffle: 1
    //sort: 14
    //Count: 100000000
    //init: 1
    //shuffle: 16
    //sort: 216
    //Count: 500000000
    //init: 14
    //shuffle: 99
    //sort: 1377

}
