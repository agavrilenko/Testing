package org.my.hrank.data_structures.arrays;

import java.util.Random;

public class QuickSorter implements Sorter {
    public int[] sort(int[] src) {

        Random r = new Random();
        int idx;
        int t;
        for (int i = src.length - 1; i > 0; i--) {
            idx = r.nextInt(i);
            t = src[i];
            src[i] = src[idx];
            src[idx] = t;
        }

        int lo = 0;
        int hi = src.length - 1;

        sort(lo, hi, src);

        return src;
    }

    private void sort(int lo, int hi, int[] src) {

        if (lo >= hi) {
            return;
        }
        int initLo = lo;
        int initHi = hi;
        int pivot = src[lo];
        int mi = lo;
        while (lo < hi) {

            int curr = src[lo + 1];
            if (curr < pivot) {
                swap(lo + 1, mi, src);
                lo++;
                mi++;
            }
            if (curr > pivot) {
                swap(lo + 1, hi, src);
                hi--;
            }
            if (curr == pivot) {
                lo++;
            }

        }
        sort(initLo, mi - 1, src);
        if(pivot == src[initLo]){
            hi++;
        }
        sort(hi, initHi, src);
    }

    private void swap(int f, int s, int[] src) {
        int t = src[f];
        src[f] = src[s];
        src[s] = t;
    }
}
