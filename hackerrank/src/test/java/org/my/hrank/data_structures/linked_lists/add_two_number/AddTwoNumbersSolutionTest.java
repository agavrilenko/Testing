package org.my.hrank.data_structures.linked_lists.add_two_number;

import org.junit.Assert;
import org.junit.Test;

import static org.my.hrank.data_structures.linked_lists.add_two_number.AddTwoNumbersSolution.ListNode;
import static org.my.hrank.data_structures.linked_lists.add_two_number.AddTwoNumbersSolution.Solution;


public class AddTwoNumbersSolutionTest {


    @Test
    public void test1() {
        ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(3);

        ListNode second = new ListNode(5);
        second.next = new ListNode(6);
        second.next.next = new ListNode(4);

        ListNode expected = new ListNode(7);
        expected.next = new ListNode(0);
        expected.next.next = new ListNode(8);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(first, second);

        compare(expected, result);

    }

    @Test
    public void test2() {
        ListNode first = new ListNode(9);

        ListNode second = new ListNode(1);
        second.next = new ListNode(9);
        second.next.next = new ListNode(9);
        second.next.next.next = new ListNode(9);
        second.next.next.next.next = new ListNode(9);
        second.next.next.next.next.next = new ListNode(9);
        second.next.next.next.next.next.next = new ListNode(9);
        second.next.next.next.next.next.next.next = new ListNode(9);
        second.next.next.next.next.next.next.next.next = new ListNode(9);
        second.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode expected = new ListNode(0);
        expected.next = new ListNode(0);
        expected.next.next = new ListNode(0);
        expected.next.next.next = new ListNode(0);
        expected.next.next.next.next = new ListNode(0);
        expected.next.next.next.next.next = new ListNode(0);
        expected.next.next.next.next.next.next = new ListNode(0);
        expected.next.next.next.next.next.next.next = new ListNode(0);
        expected.next.next.next.next.next.next.next.next = new ListNode(0);
        expected.next.next.next.next.next.next.next.next.next = new ListNode(0);
        expected.next.next.next.next.next.next.next.next.next.next = new ListNode(1);


        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(first, second);

        compare(expected, result);

    }

    @Test
    public void test3() {

        int[] f = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        int[] s = new int[]{5, 6, 4};
        int[] r = new int[]{6, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        ListNode first = createFromArray(f);
        ListNode second = createFromArray(s);
        ListNode expected = createFromArray(r);
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(first, second);

        compare(expected, result);

    }

    private ListNode createFromArray(int[] source) {
        ListNode root = new ListNode(source[0]);
        ListNode node = root;
        for (int i = 1; i < source.length; i++) {
            node.next = new ListNode(source[i]);
            node = node.next;

        }
        return root;
    }

    private void compare(ListNode root, ListNode rootE) {
        while (root != null || rootE != null) {
            Assert.assertEquals(String.format("Validating expected %s actual %s", rootE.val, root.val), rootE.val, root.val);
            root = root.next;
            rootE = rootE.next;
        }
    }


}