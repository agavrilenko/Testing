package org.my.testing.sorting;

import org.junit.Assert;
import org.junit.Test;
import org.my.testing.sorting.heap.HeapSort;

/**
 * Created by trash on 29-Jul-16.
 */
public class SortTest {
    @Test
    public void test(){
        int[] toSort = new int[]{3,4,5,6,2,3,9,78,0};
        HeapSort.sort(toSort);
        int i=0;
        for (int element: toSort){
            System.out.println( ++i + " is " + element  );
        }
    }
}
