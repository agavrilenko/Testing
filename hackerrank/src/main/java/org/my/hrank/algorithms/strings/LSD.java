package org.my.hrank.algorithms.strings;

/**
 * Least significant digit
 */
public class LSD {
    public static void sort(String[] a, int w) {
        int r = 256;//dictionary length
        int n = a.length;
        String[] aux = new String[n];
        for (int d = w - 1; d >= 0; d--) {
            int[] count = new int[r + 1];
            for (int i = 0; i < n; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            for (int i = 0; i < r; r++) {
                count[i + 1] += count[i];
            }
            for (int i = 0; i < n; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }
        }
    }
}
