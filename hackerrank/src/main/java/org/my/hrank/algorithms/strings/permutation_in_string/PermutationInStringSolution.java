package org.my.hrank.algorithms.strings.permutation_in_string;

public class PermutationInStringSolution {
    public boolean checkInclusion(String s1, String s2) {

        int offset = 97;//ascii offset for lower case 'a'=97
        int[] firstSt = new int[122 - 97 + 1];
        int[] secondSt = new int[122 - 97 + 1];
        char[] firstChars = s1.toCharArray();
        for (char a : firstChars) {
            firstSt[a - offset]++;
        }
        char[] secondChars = s2.toCharArray();
        int matches = 0;
        int leftIdx = 0;
        for (int i = 0; i < secondChars.length & matches < firstChars.length; i++) {
            char cur = secondChars[i];
            int charIdx = cur - offset;
            if (i >= firstChars.length) {
                leftIdx = i - firstChars.length + 1;
                //remove symbol left to window of length s1
                int removeIdx = secondChars[leftIdx - 1] - offset;
                if (firstSt[removeIdx] > 0 && firstSt[removeIdx] >= secondSt[removeIdx] ) {
                    matches--;
                }
                secondSt[removeIdx]--;

            }
            secondSt[charIdx]++;
            if (firstSt[charIdx] != 0 && firstSt[charIdx] >= secondSt[charIdx]) {
                matches++;
            }
        }
        return matches == firstChars.length;
    }
}
