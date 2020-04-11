package org.my.hrank.data_structures.linked_lists.palindrome;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.my.hrank.data_structures.linked_lists.palindrome.PalindromeSolution.ListNode;

public class PalindromeSolutionTest {
    PalindromeSolution.Solution solution;

    @Before
    public void init() {
        solution = new PalindromeSolution.Solution();

    }

    @Test
    public void test1() {
        int[] list = new int[]{1, 2};
        ListNode root = createFromArray(list);
        Assert.assertEquals(false, solution.isPalindrome(root));

    }

    @Test
    public void test2() {
        int[] list = new int[]{1, 2, 2, 1};
        ListNode root = createFromArray(list);
        Assert.assertEquals(true, solution.isPalindrome(root));

    }

    @Test
    public void test3() {
        int[] list = new int[]{1, 2, 3, 2, 1};
        ListNode root = createFromArray(list);
        Assert.assertEquals(true, solution.isPalindrome(root));

    }

    @Test
    public void test4() {
        int[] list = new int[]{1, 2, 3, 4, 2, 1};
        ListNode root = createFromArray(list);
        Assert.assertEquals(false, solution.isPalindrome(root));

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