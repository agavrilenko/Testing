package org.my.hrank.algorithms.dynamic_programming.four_sum;

import java.util.HashMap;

/**
 * Four sum ii
 * https://leetcode.com/problems/4sum-ii/
 */
public class FourSum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        HashMap<Integer, Integer> ab = new HashMap<>();
        HashMap<Integer, Integer> cd = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                ab.putIfAbsent(sum, 0);
                ab.put(sum, ab.get(sum) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                result += ab.get(-1 * sum) == null ? 0 : ab.get(-1 * sum);
            }
        }


        return result;
    }
}
