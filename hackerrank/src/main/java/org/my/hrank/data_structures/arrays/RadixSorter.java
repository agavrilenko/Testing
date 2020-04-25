package org.my.hrank.data_structures.arrays;

import java.util.Arrays;

/**
 * Has two implementation -
 * sort - int sorter
 * sortStable - stable sorting to keep initial relative order
 */
public class RadixSorter implements Sorter {
    @Override
    public int[] sort(int[] src) {

        int max = Arrays.stream(src).max().getAsInt();
        int aux[] = new int[max + 1];
//        int fin[] = new int[max + 1];
        for (int i = 0; i < src.length; i++) {
            aux[src[i]]++;
        }
        int sIdx = 0;
        int aIdx = 0;
        while (aIdx < aux.length) {
            if (aux[aIdx] <= 0) {
                aIdx++;
                continue;
            }
            src[sIdx++] = aIdx;
            aux[aIdx]--;
        }
        return src;
    }

    public int[] sortStable(int[] src) {

        int max = Arrays.stream(src).max().getAsInt();
        int aux[] = new int[max + 1];
        int fin[] = new int[src.length];
        for (int i = 0; i < src.length; i++) {
            aux[src[i]]++;
        }

        int pos = 0;
        int curr = 0;
        for (int i = 0; i < aux.length; i++) {
            curr = pos + aux[i];
            aux[i] = pos;
            pos = curr;
        }
        for (int i = 0; i < src.length; i++) {
            fin[aux[src[i]]++] = src[i];
        }
        return fin;
    }
}
