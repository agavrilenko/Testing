package org.my.hrank.data_structures.arrays;

import org.junit.Test;


public class QuickSorterLongTest extends AbstractSorterLongTest {

    public QuickSorterLongTest(int n) {
        this.n = n;
    }

    @Override
    public Sorter getSorder() {
        return new QuickSorter();
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
    //sort: 7
    //Count: 100000000
    //init: 1
    //shuffle: 15
    //sort: 91
    //Count: 500000000
    //init: 8
    //shuffle: 101
    //sort: 495

}
