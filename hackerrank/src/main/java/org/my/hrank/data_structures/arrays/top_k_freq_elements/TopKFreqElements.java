package org.my.hrank.data_structures.arrays.top_k_freq_elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TopKFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> store = new HashMap<>();
        for (int el : nums) {
            if (store.get(el) == null) {
                store.put(el, 0);
            }
            store.put(el, store.get(el) + 1);
        }

        Pair[] pairs = new Pair[store.size()];
        int idx = 0;
        Iterator<Integer> it = store.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            pairs[idx++] = new Pair(key, store.get(key));
        }
        Arrays.sort(pairs);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pairs[i].key;
        }


        return result;
    }

    private static class Pair implements Comparable<Pair> {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Pair o) {
            if (this.value > o.value) {
                return -1;
            }
            if (this.value < o.value) {
                return 1;
            }
            return 0;
        }
    }
}
