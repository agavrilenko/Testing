package org.my.hrank.algorithms.strings.longest_dup_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1044. Longest Duplicate Substring
 * https://leetcode.com/problems/longest-duplicate-substring/
 */

/**
 * Binary Search:
 * <p>
 * We do binary search on the duplicate substring length, for example if we know a length 10 substring has duplicate, then there is no need to test any substring with length smaller than 10 right?
 * <p>
 * Rolling Hash:
 * Take this string "12121" as an example, we want to find out whether we have duplicate substring with length 3:
 * <p>
 * A simple hash computation for its 1st 3 character substring "121" would be 1*10^2 + 2*10^1 + 1*10^0 = 121 (basically we used its decimal value as its unique hash in this example)
 * For 2nd substring "212" would be (121 - 1*10^2) * 10 + 2 * 10^0 = 212
 * For 3rd substring "121" would be (212 - 2*10^2) * 10 + 1 * 10^0 = 121 and we now have a collision!
 * <p>
 * Did you notice the hash computation is constant time for each substring? That's the key of this algorithm, we can use previous substring's hash to compute the current substring's hash because current substring is simply previous substring with first character removed and new character added to the end.
 * <p>
 * Princeton's JAVA code on RabinKarp: https://algs4.cs.princeton.edu/53substring/RabinKarp.java.html
 *
 * Second  place is sort and compare.
 *
 * Ternar trie 3d - memory
 *
 * Regular trie 4th - memory
 *
 *
 */
public class LongestDuplicateString {

    private static final long q = (1 << 31) - 1;
    private static final long R = 256;

    public String longestDupSubstring(String S) {
        int left = 2;
        int right = S.length() - 1;
        int start = 0;
        int maxLen = 0;

        while (left <= right) {
            int len = left + (right - left) / 2;
            boolean found = false;

            Map<Long, List<Integer>> map = new HashMap<>();
            long hash = hash(S, len);
            map.put(hash, new ArrayList<>());
            map.get(hash).add(0);
            long RM = 1l;
            for (int i = 1; i < len; i++) RM = (R * RM) % q;

            loop:

            for (int i = 1; i + len <= S.length(); i++) {
                hash = (hash + q - RM * S.charAt(i - 1) % q) % q;
                hash = (hash * R + S.charAt(i + len - 1)) % q;
                if (!map.containsKey(hash)) {
                    map.put(hash, new ArrayList<>());
                } else {
                    for (int j : map.get(hash)) {
                        if (compare(S, i, j, len)) {
                            found = true;
                            start = i;
                            maxLen = len;
                            break loop;
                        }
                    }
                }
                map.get(hash).add(i);
            }
            if (found) left = len + 1;
            else right = len - 1;
        }

        return S.substring(start, start + maxLen);
    }

    private long hash(String S, int len) {
        long h = 0;
        for (int j = 0; j < len; j++) h = (R * h + S.charAt(j)) % q;
        return h;
    }

    private boolean compare(String S, int i, int j, int len) {
        for (int count = 0; count < len; count++) {
            if (S.charAt(i++) != S.charAt(j++)) return false;
        }
        return true;
    }
    ////////////

    /////////TST/////////

    public String longestDupSubstring3(String S) {
//        char[] src = S.toCharArray();
        TST<Integer> tstTrie = new TST<>();
        tstTrie.root = tstTrie.getEmptyNode();
        int len = 0;
        int idx0 = 0;
        for (int i = 0; i < S.length(); i++) {
            AtomicInteger deep = new AtomicInteger(0);
            tstTrie.put(S.substring(i), i, deep);
            if (len < deep.get()) {
                len = deep.get();
                idx0 = i;
            }

        }
        return S.substring(idx0, idx0 + len);
    }

    public static class TST<Value> {
        private Node root;

        public Node getEmptyNode() {
            Node node = new Node();
            node.left = new Node();
            node.mid = new Node();
            node.right = new Node();
            return node;
        }

        public void put(String key, Value val, AtomicInteger len) {
            Node next = root;
            int d = 0;
            while (d < key.length()) {
                char c = key.charAt(d);
                if (isEmpty(next)) {
                    next.c = c;
                    d++;
                    initEmpty(next);
                    next = next.mid;
                    continue;
                }
                if (!isEmpty(next) && c < next.c) {
                    if (isEmpty(next.left)) {
                        initEmpty(next.left);
                    }
                    next = next.left;
                    continue;
                }
                if (!isEmpty(next) && c > next.c) {
                    if (isEmpty(next.right)) {
                        initEmpty(next.right);
                    }
                    next = next.right;
                    continue;
                }
                if (!isEmpty(next) && c == next.c) {
                    len.incrementAndGet();
                    d++;
                    if (isEmpty(next.mid)) {
                        initEmpty(next.mid);
                    }
                    next = next.mid;
                }
            }
        }

        private void initEmpty(Node next) {
            next.left = new Node();
            next.mid = new Node();
            next.right = new Node();
        }

        private boolean isEmpty(Node n) {
            return n.c == (char) 0;
        }

        private Node put(Node root, String key, Value val, int d, AtomicInteger len) {
            char c = key.charAt(d);
            if (root == null) {
                root = new Node();
                root.c = c;
            } else if (c == root.c) {
                len.incrementAndGet();
            }
            //todo make non recurcive
            if (c < root.c) {
                root.left = put(root.left, key, val, d, len);
            } else if (c > root.c) {
                root.right = put(root.right, key, val, d, len);
            } else if (d < key.length() - 1) {
                root.mid = put(root.mid, key, val, d + 1, len);
            } else {
                root.val = val;
            }
            return root;
        }

        public Value get(String key) {
            Node x = get(root, key, 0);
            if (x == null) {
                return null;
            }
            return x.val;
        }

        private Node get(Node x, String key, int d) {
            if (x == null) {
                return null;
            }
            char c = key.charAt(d);
            if (c < x.c) {
                return get(x.left, key, d);
            } else if (c > x.c) {
                return get(x.right, key, d);
            } else if (d < key.length() - 1) {
                return get(x.mid, key, d + 1);
            } else {
                return x;
            }
        }


        public class Node {

            private Value val;
            private char c;
            private Node left, right, mid;

        }
    }

    ///////////////
    public String longestDupSubstring1(String S) {
        String[] arr = new String[S.length()];

        for (int i = 0; i < S.length(); i++) {
            arr[i] = S.substring(i, S.length());
        }
        Arrays.sort(arr);
        int mLen = 0;
        int mIdx = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int len = 0;
            for (int j = 0; j < arr[i].length() && j < arr[i + 1].length(); j++) {
                if (arr[i].charAt(j) != arr[i + 1].charAt(j)) {
                    break;
                }
                if (arr[i].charAt(j) == arr[i + 1].charAt(j)) {
                    len++;
                    if (len > mLen) {
                        mIdx = i;
                        mLen = len;
                    }
                }

            }
        }
        return arr[mIdx].substring(0, mLen);

//        return getLongestSubstring(S);
    }

    private String getLongestSubstring(String S) {
        char[] src = S.toCharArray();
        Trie root = new Trie((char) 0);
        int len = 0;
        int idx0 = 0;
        for (int i = 0; i < src.length; i++) {
            AtomicInteger deep = new AtomicInteger(0);
            root.add(src, i, deep);
            if (len < deep.get()) {
                len = deep.get();
                idx0 = i;
            }

        }
        return new String(Arrays.copyOfRange(src, idx0, idx0 + len));
    }

    private static class Trie {
        int offset = 'a';
        Trie[] nodes = new Trie['z' - 'a' + 1];
        char ch;

        public Trie(char ch) {
            this.ch = ch;
        }

        public void add(char[] arr, int idx, AtomicInteger deep) {
            if (idx < arr.length) {
                if (nodes[arr[idx] - offset] == null) {
                    nodes[arr[idx] - offset] = new Trie(arr[idx]);
                } else {
                    deep.incrementAndGet();
                }

                nodes[arr[idx] - offset].add(arr, idx + 1, deep);
            }
        }
    }

}
