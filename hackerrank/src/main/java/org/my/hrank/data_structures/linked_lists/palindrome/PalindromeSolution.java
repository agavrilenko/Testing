package org.my.hrank.data_structures.linked_lists.palindrome;

public class PalindromeSolution {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        public boolean isPalindrome(ListNode head) {

            ListNode reverse = reverse(head);

            ListNode dir = head;
            ListNode rev = reverse;

            while (dir != null && rev != null) {
                if (dir.val != rev.val) {
                    return false;
                }
                dir = dir.next;
                rev = rev.next;
            }


            return true;
        }

        private ListNode reverse(ListNode head) {
            if(head == null){
                return null;
            }
            ListNode root = new ListNode(head.val);
            ListNode tail = new ListNode(head.val);
            ListNode next = head.next;
            while (next != null) {
                root = new ListNode(next.val);
                root.next = tail;
                tail = root;
                next = next.next;
            }
            return root;
        }
    }
}
