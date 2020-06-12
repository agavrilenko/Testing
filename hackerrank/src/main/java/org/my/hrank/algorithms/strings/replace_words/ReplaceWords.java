package org.my.hrank.algorithms.strings.replace_words;

import java.util.List;

/**
 * Replace words
 * https://leetcode.com/problems/replace-words/
 */
public class ReplaceWords {
    final static int length = 'z' - 'a' + 1;
    final static int offset = 'a';

    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder result = new StringBuilder("");
        Trie root = new Trie();
        //build trie
        for (String word : dict) {
            root.add(word, 0);
        }

        String[] words = sentence.split(" ");
        for (String word : words) {
            int len = root.rootLength(word, 0);
            result.append(word, 0, len).append(" ");
        }
        //remove last space
        result.deleteCharAt(result.length() - 1);
        return result.toString();

    }

    private static class Trie {
        Trie[] next = new Trie[length];
        boolean isWord = false;

        public int rootLength(String word, int idx) {
            if (isWord) {
                return idx;
            }
            if (idx == word.length()) {
                return word.length();
            }
            Trie trie = next[word.charAt(idx) - offset];
            if (trie == null) {
                return word.length();
            }
            return trie.rootLength(word, idx + 1);
        }

        public void add(String arr, int idx) {
            if (idx == arr.length()) {
                this.isWord = true;
                return;
            }
            if (next[arr.charAt(idx) - offset] == null) {
                next[arr.charAt(idx) - offset] = new Trie();
            }
            next[arr.charAt(idx) - offset].add(arr, idx + 1);
        }
    }
}
