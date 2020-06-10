package org.my.hrank.algorithms.dynamic_programming.four_sum;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Four sum 4sum
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        int[][] store = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            store[i][i] = nums[i];
        }
        //calculate pairs
        HashMap<Integer, Set<Pair>> map = new HashMap<>();
        for (int ro = 0; ro < store.length; ro++) {
            for (int co = ro + 1; co < store.length; co++) {
                store[ro][co] = store[ro][ro] + store[co][co];
                if (map.get(store[ro][co]) == null) {
                    map.put(store[ro][co], new HashSet<>());
                }
                map.get(store[ro][co]).add(new Pair(ro, co));
                if (map.get(target - store[ro][co]) != null) {
                    for (Pair pair : map.get(target - store[ro][co])) {
                        if (pair.a != ro && pair.b != co && pair.b != ro && pair.a != co) {
                            List<Integer> list = Arrays.asList(store[ro][ro], store[co][co], store[pair.a][pair.a], store[pair.b][pair.b]);
                            Collections.sort(list);
                            result.add(list);
                        }
                    }
                }
            }
        }
        List<List<Integer>> lists = result.stream().collect(Collectors.toList());
        return lists;
    }


    private static class Pair {
        private int a;
        private int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        List<Integer> toList() {
            return Arrays.asList(a, b);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return a == pair.a &&
                    b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
