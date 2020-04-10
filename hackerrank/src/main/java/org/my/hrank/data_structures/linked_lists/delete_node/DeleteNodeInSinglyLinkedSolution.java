package org.my.hrank.data_structures.linked_lists.delete_node;

public class DeleteNodeInSinglyLinkedSolution {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
