package org.my.hrank.data_structures.arrays;

public class MergeSorter implements Sorter {

    public  int[] sort(int[] src) {

        int[] aux = new int[src.length];
        sort(src, 0, src.length - 1, aux);


        return src;
    }

    private void sort(int[] src, int lo, int hi, int[] aux) {

        if (lo == hi) {
            return;
        }
        sort(src, lo, (lo + hi) / 2, aux);
        sort(src, (lo + hi) / 2 + 1, hi, aux);
        merge(src, lo, (lo + hi) / 2 + 1, hi, aux);
    }

    private void merge(int[] src, int lo, int mid, int hi, int[] aux) {
        if (hi + 1 - lo >= 0) {
            System.arraycopy(src, lo, aux, lo, hi + 1 - lo);
        }
        int tLo = lo;
        int tM = mid;
        for (int i = tLo; i <= hi; i++) {
            if (lo >= mid) {
                src[i] = aux[tM];
                tM++;
                continue;
            }
            if (tM > hi) {
                src[i] = aux[lo];
                lo++;
                continue;
            }
            if (tM <= hi && aux[lo] >= aux[tM]) {
                src[i] = aux[tM];
                tM++;

            } else if (lo < mid && aux[lo] < aux[tM]) {
                src[i] = aux[lo];
                lo++;

            }
        }
    }
}
