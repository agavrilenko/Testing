package org.my.hrank.data_structures.arrays.binary_subarray_with_sum;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] A, int S) {
        int sum = 0, lo = 0, hi = 0, count = 0, zLeft = 0, zRight = 0;
        if (S != 0) {
            while (hi < A.length && lo < A.length) {
                sum += A[hi];
                if (sum == S) {
                    while (lo < A.length - 1 && sum - A[lo] == S) {
                        zLeft++;
                        lo++;
                    }
                    while (hi + 1 < A.length && sum + A[hi + 1] == S) {
                        zRight++;
                        hi++;
                    }
                    if (S == 0) {
                        count += (zLeft + 1) * (zLeft + 2) / 2;
                    } else {
                        count += (zRight + 1) * (zLeft + 1);
                    }
                    zRight = 0;
                    zLeft = 0;
                    sum -= A[lo];
                    if (lo + 1 < A.length) {
                        lo++;
                    }
                }
                hi++;

            }
            return count;
        } else {

            for (int i = 0; i < A.length; i++) {
                if (A[i] == 0) {
                    hi++;
                } else {
                    count += hi * (hi + 1) / 2;
                    hi = 0;
                }
            }
            count += hi * (hi + 1) / 2;
            return count;
        }
    }
}
