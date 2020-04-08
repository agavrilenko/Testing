package org.my.hrank.algorithms.dynamic_programming.levenstein_distance;

import java.util.stream.IntStream;

public class MinDistanceSolution {
    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int m[][] = new int[s2.length + 1][s1.length + 1];

        for (int i = 0; i < m.length; i++) {
            m[i][0] = i;
        }

        for (int j = 0; j < m[0].length; j++) {
            m[0][j] = j;
        }

        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                int s1Idx = j - 1;
                int s2Idx = i - 1;
                if (s1[s1Idx] == s2[s2Idx]) {
                    m[i][j] = m[i - 1][j - 1];
                } else {
                    m[i][j] = IntStream.of(m[i][j - 1], m[i - 1][j - 1], m[i - 1][j]).min().getAsInt() + 1;
                }
            }
        }

        return m[s2.length][s1.length];
    }
}
