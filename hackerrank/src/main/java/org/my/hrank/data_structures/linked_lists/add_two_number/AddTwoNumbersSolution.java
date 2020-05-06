package org.my.hrank.data_structures.linked_lists.add_two_number;

/**
 * Add two numbers https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbersSolution {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode root = new ListNode((l1.val + l2.val) % 10);
            int overflow = (l1.val + l2.val) / 10;
            ListNode next = root;

            int value;
            ListNode currentF = l1;
            ListNode currentS = l2;
            while (currentF.next != null || currentS.next != null) {

                if (currentF.next != null && currentS.next != null) {
                    value = (overflow + currentF.next.val + currentS.next.val) % 10;
                    overflow = (overflow + currentF.next.val + currentS.next.val) / 10;
                    next.next = new ListNode(value);
                    currentF = currentF.next;
                    currentS = currentS.next;
                    next = next.next;
                }
                if (currentF.next != null && currentS.next == null) {
                    value = (overflow + currentF.next.val) % 10;
                    overflow = (overflow + currentF.next.val) / 10;
                    next.next = new ListNode(value);
                    currentF = currentF.next;
                    next = next.next;
                }

                if (currentF.next == null && currentS.next != null) {
                    value = (overflow + currentS.next.val) % 10;
                    overflow = (overflow + currentS.next.val) / 10;
                    next.next = new ListNode(value);
                    currentS = currentS.next;
                    next = next.next;
                }
            }
            if (overflow != 0) {
                next.next = new ListNode(overflow);
            }
            return root;
        }
    }
}
