package org.my.hrank.algorithms.strings.longest_palindromic_substring;

/**
 * Longest palindromic substring
 * https://leetcode.com/problems/longest-palindromic-substring
 */
public class LongestPalindromicSubstringSolution {
    public String longestPalindrome(String s) {

        char[] source = s.toCharArray();
        if (source.length < 2) {
            return s;
        }
        int lo = 0;
        int up = 0;
        int len = 1;
        boolean goNext = true;
        //for odd palindromes
        for (int i = 1; i < source.length - 1; i++) {
            goNext = true;
            while (goNext) {

                if (i - len >= 0 && i + len < source.length && source[i - len] == source[i + len]) {
                    len++;

                } else {
                    if (up - lo + 1 < 2 * (len - 1) + 1) {
                        up = i + (len - 1);
                        lo = i - (len - 1);
                    }
                    goNext = false;
                    len = 1;
                }
            }
        }
        //for even
        for (int i = 0; i < source.length - 1; i++) {
            if (source[i] == source[i + 1]) {

                goNext = true;
                while (goNext) {

                    if (i - len >= 0 && (i + 1) + len < source.length && source[i - len] == source[i + 1 + len]) {
                        len++;

                    } else {
                        if (up - lo + 1 < 2 * (len - 1) + 2) {
                            up = i + (len - 1) + 1;
                            lo = i - (len - 1);
                        }
                        goNext = false;
                        len = 1;
                    }
                }
            }
        }
        return s.substring(lo, up + 1);
    }
}
