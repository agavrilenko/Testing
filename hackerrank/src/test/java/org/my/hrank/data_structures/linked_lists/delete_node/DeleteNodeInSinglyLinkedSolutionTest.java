package org.my.hrank.data_structures.linked_lists.delete_node;

import org.junit.Assert;
import org.junit.Test;

import static org.my.hrank.data_structures.linked_lists.delete_node.DeleteNodeInSinglyLinkedSolution.ListNode;
import static org.my.hrank.data_structures.linked_lists.delete_node.DeleteNodeInSinglyLinkedSolution.Solution;

public class DeleteNodeInSinglyLinkedSolutionTest {

    @Test
    public void test() {
        ListNode root = new ListNode(4);
        root.next = new ListNode(5);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(9);

        ListNode rootE = new ListNode(4);
        rootE.next = new ListNode(1);
        rootE.next.next = new ListNode(9);

        Solution solution = new Solution();
        solution.deleteNode(root.next);

        compare(root, rootE);
    }

    @Test
    public void test1() {
        ListNode root = new ListNode(4);
        root.next = new ListNode(5);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(9);

        ListNode rootE = new ListNode(4);
        rootE.next = new ListNode(5);
        rootE.next.next = new ListNode(9);

        Solution solution = new Solution();
        solution.deleteNode(root.next.next);

        compare(root, rootE);
    }

    private void compare(ListNode root, ListNode rootE) {
        while (root.next != null || rootE.next != null) {
            Assert.assertEquals(String.format("Validating expected %s actual %s", rootE.next.val, root.next.val), rootE.next.val, root.next.val);
            root = root.next;
            rootE = rootE.next;
        }
    }


}