package org.my.hrank.data_structures.linked_lists.add_two_number;


import java.math.BigDecimal;

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
            java.math.BigDecimal first = new java.math.BigDecimal(0);
            java.math.BigDecimal second = new java.math.BigDecimal(0);
            java.math.BigDecimal result = new java.math.BigDecimal(0);
            ListNode current = l1;
            int pow = 0;
            while (current != null) {
                first = first.add((new java.math.BigDecimal(current.val)).multiply(new java.math.BigDecimal(10).pow(pow++)));
                current = current.next;
            }
            current = l2;
            pow = 0;
            while (current != null) {
                second = second.add((new java.math.BigDecimal(current.val)).multiply(new java.math.BigDecimal(10).pow(pow++)));
                current = current.next;
            }

            result = first.add(second);

            char resS[] = result.toPlainString().toCharArray();
            int len = resS.length - 1;
            ListNode root = new ListNode(Integer.valueOf("" + resS[len--]));
            ListNode next = root;
            while (len > -1) {
                next.next = new ListNode(Integer.valueOf("" + resS[len]));
                next = next.next;
                len--;
            }

            return root;
        }
    }
}
