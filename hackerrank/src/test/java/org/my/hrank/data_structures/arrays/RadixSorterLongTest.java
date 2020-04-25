package org.my.hrank.data_structures.arrays;

import org.junit.Test;

public class RadixSorterLongTest extends AbstractSorterLongTest {

    public RadixSorterLongTest(int n) {
        this.n = n;
    }

    @Override
    public Sorter getSorder() {
        return new RadixSorter();
    }

    @Test
    public void test() {
        super.test();
    }
    //Count: 1000000
    //init: 0
    //shuffle: 0
    //sort: 0
    //Count: 10000000
    //init: 0
    //shuffle: 1
    //sort: 0
    //Count: 100000000
    //init: 1
    //shuffle: 18
    //sort: 11
    //Count: 500000000
    //init: 9
    //shuffle: 108
    //sort: 76
}