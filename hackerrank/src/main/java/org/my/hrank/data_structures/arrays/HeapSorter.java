package org.my.hrank.data_structures.arrays;

import java.util.stream.IntStream;

public class HeapSorter implements Sorter {
    @Override
    public int[] sort(int[] src) {

        Heap heap = new Heap(src.length);
        for (int i = 0; i < src.length; i++) {
            heap.put(src[i]);
        }
        for (int i = src.length - 1; i >= 0; i--) {
            src[i] = heap.removeMax();
        }

        return src;
    }


    private static class Heap {
        int[] heap;
        int cnt = 0;
        int nill = Integer.MIN_VALUE;

        public Heap(int length) {
            heap = IntStream.generate(() -> nill).limit(length + 1).toArray();
        }

        public void put(int h) {
            cnt++;
            heap[cnt] = h;

            swim(heap[cnt], cnt);

        }

        private int removeMax() {
            int tmp;
            tmp = heap[1];
            heap[1] = heap[cnt];
            heap[cnt] = nill;
            cnt--;
            sink(1);
            return tmp;
        }

        public int[] sorted() {
            return new int[1];
        }


        private void swim(int n, int pos) {
            if (pos / 2 == 0) {
                return;
            }
            if (heap[pos / 2] < n) {
                int tmp = heap[pos / 2];
                heap[pos / 2] = n;
                heap[pos] = tmp;
                swim(heap[pos / 2], pos / 2);
            }
        }

        private void sink(int pos) {

            if (2 * pos > cnt ) {
                return;
            }
            int tmp;
            if (heap[pos] < heap[2 * pos] && (2 * pos + 1 > cnt  || heap[pos] >= heap[2 * pos + 1])) {
                tmp = heap[pos];
                heap[pos] = heap[2 * pos];
                heap[2 * pos] = tmp;
                sink(2 * pos);
            }
            if (2 * pos + 1 <= cnt  && heap[pos] < heap[2 * pos + 1] && heap[pos] >= heap[2 * pos]) {
                tmp = heap[pos];
                heap[pos] = heap[2 * pos + 1];
                heap[2 * pos + 1] = tmp;
                sink(2 * pos + 1);
            }
            if (2 * pos + 1 <= cnt && heap[pos] < heap[2 * pos + 1] && heap[pos] < heap[2 * pos]) {
                if (heap[2 * pos] > heap[2 * pos + 1]) {
                    tmp = heap[pos];
                    heap[pos] = heap[2 * pos];
                    heap[2 * pos] = tmp;
                    sink(2 * pos);
                } else {
                    tmp = heap[pos];
                    heap[pos] = heap[2 * pos + 1];
                    heap[2 * pos + 1] = tmp;
                    sink(2 * pos + 1);
                }
            }

        }

    }


}
