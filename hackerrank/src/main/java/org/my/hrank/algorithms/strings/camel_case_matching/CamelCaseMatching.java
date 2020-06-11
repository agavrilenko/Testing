package org.my.hrank.algorithms.strings.camel_case_matching;

import java.util.ArrayList;
import java.util.List;

/**
 * Camel case matching
 * https://leetcode.com/problems/camelcase-matching/
 */
public class CamelCaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> result = new ArrayList<>(queries.length);
        int idx = 0;
        for (int j = 0; j < queries.length; j++) {
            String query = queries[j];
            idx = 0;
            char p = pattern.charAt(idx);
            boolean br = false;
            for (int i = 0; i < query.length(); i++) {
                char q = query.charAt(i);
                if (p == q && idx < pattern.length()) {
                    idx++;
                    if (idx < pattern.length()) {
                        p = pattern.charAt(idx);
                    }
                } else if (q <= 'Z' && q >= 'A') {
                    result.add(false);
                    br = true;
                    break;
                }

            }
            if (!br) {
                if (idx == pattern.length()) {
                    result.add(true);
                } else {
                    result.add(false);
                }
            }
        }
        return result;
    }
}
